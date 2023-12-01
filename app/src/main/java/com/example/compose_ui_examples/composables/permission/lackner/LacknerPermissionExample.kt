package com.example.compose_ui_examples.composables.permission.lackner

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LacknerPermissionExample() {

    val context = LocalContext.current
    val activity = context as? Activity

    val openSettings = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }



    val permissionToRequest = arrayOf(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CALL_PHONE,
    )

    val viewModel = viewModel<MainViewModel>()
    val dialogQueue = viewModel.visiblePermissionDialogQueue


    val cameraPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            viewModel.onPermissionResult(
                permission = Manifest.permission.CAMERA,
                isGranted = isGranted
            )
        }
    )

    val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { perms ->
            permissionToRequest.forEach { permission ->
                viewModel.onPermissionResult(
                    permission = permission,
                    isGranted = perms[permission] == true
                )
            }

        }
    )




    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            cameraPermissionResultLauncher.launch(
                Manifest.permission.CAMERA
            )

        }) {
            Text(text = "single permission")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            multiplePermissionResultLauncher.launch(permissionToRequest)
        }) {
            Text(text = "multiple permission")
        }
    }


    dialogQueue.reversed().forEach { permission ->
        PermissionDialog(
            permissionTextProvider = when (permission) {
                Manifest.permission.CAMERA -> {
                    CameraPermissionTextProvider()
                }
                Manifest.permission.RECORD_AUDIO -> {
                    RecordAudioPermissionTextProvider()
                }
                Manifest.permission.CALL_PHONE -> {
                    PhoneCallPermissionTextProvider()
                }
                else -> return@forEach
            },
//            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
//                permission
//            ),
            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(activity!!, permission),

//                      onDismiss = { },
            onDismiss = viewModel::dismissDialog,
            onOkClicked = {
                viewModel.dismissDialog()
                multiplePermissionResultLauncher.launch(
                    arrayOf(permission),
                )
            },
//            onGoToAppSettingsClicked = ::openAppSetting,
            onGoToAppSettingsClicked = {
                openSettings.launch(
                    getAppDetailsIntent(context.packageName)
                )
            }

        )
    }


}

private fun getAppDetailsIntent(packageName: String): Intent {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    return intent
}



