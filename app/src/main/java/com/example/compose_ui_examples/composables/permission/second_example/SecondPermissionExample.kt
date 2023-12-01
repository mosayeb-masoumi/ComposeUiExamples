package com.example.compose_ui_examples.composables.permission.second_example

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SecondPermissionExample() {

    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    var counter = remember{ mutableStateOf(0) }
    val openSettings = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }



    val showDialog = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    val myMultiplePermissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CALL_PHONE,
            Manifest.permission.RECORD_AUDIO,
        )
    )



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(onClick = {

            if (cameraPermissionState.status.isGranted) {
                var a = 5;
            } else {

                if (cameraPermissionState.status.shouldShowRationale) {

                    counter.value ++
                    //denied
                    var a = 5
                    // If the user has denied the permission but the rationale can be shown,
                    // then gently explain why the app requires this permission
                    "The camera is important for this app. Please grant the permission."
                } else {


                    if (counter.value > 0) {  // show popup to open setting

                        coroutineScope.launch {
                            showDialog.value = true
                        }
                    }

                    counter.value++

                    // if the second time this method called  means permanently denied  show dialog to goto AppSettings
                    // but first time means its the first time that user click on it


                    // If it's the first time the user lands on this feature, or the user
                    // doesn't want to be asked again for this permission, explain that the
                    // permission is required
                    "Camera permission required for this feature to be available. " +
                            "Please grant the permission"
                }
                cameraPermissionState.launchPermissionRequest()
                var f = 5
            }


        }) {
            Text(text = "single permission")
        }

        Spacer(modifier = Modifier.height(16.dp))




        Button(onClick = {

            if (myMultiplePermissionState.permissions[0].status.isGranted &&
                myMultiplePermissionState.permissions[1].status.isGranted
            ) {
                var a = 5;
            } else {

                if (myMultiplePermissionState.permissions[0].status.shouldShowRationale
                    && myMultiplePermissionState.permissions[1].status.shouldShowRationale
                ) {

                    //denied
                    var a = 5
                    // If the user has denied the permission but the rationale can be shown,
                    // then gently explain why the app requires this permission
                    "The camera is important for this app. Please grant the permission."
                } else {


                    // if the second time this method called  means permanently denied  show dialog to goto AppSettings
                    // but first time means its the first time that user click on it


                    // If it's the first time the user lands on this feature, or the user
                    // doesn't want to be asked again for this permission, explain that the
                    // permission is required
                    "Camera permission required for this feature to be available. " +
                            "Please grant the permission"
                }
                myMultiplePermissionState.launchMultiplePermissionRequest()
                var f = 5;
            }


        }) {
            Text(text = "multiple permission")
        }



        if (showDialog.value && !cameraPermissionState.status.shouldShowRationale) {

            ShowDialog(type = "permanently_denied", showDialog , openSettings)

        }

    }
}


@Composable
fun ShowDialog(
    type: String,
    showDialog: MutableState<Boolean>,
    openSettings: ManagedActivityResultLauncher<Intent, ActivityResult>
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .background(color = Color.Gray)
            .clip(RoundedCornerShape(30.dp))
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "title")

                Icon(
                    Icons.Default.Close,
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            showDialog.value = false
                        })
            }

            Text(
                text = "user permanently denied the permission " +
                        "to enable it goto setting "
            )

            Spacer(modifier = Modifier.height(20.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                color = Color.Gray,
                thickness = 1.dp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp)
                    .background(color = Color.Green)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .clickable {


                        openSettings.launch(
                            getTheAppDetailsIntent(context.packageName)
                        )
                        showDialog.value = false
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "close", style = TextStyle(color = Color.White))
            }

        }
    }
}


private fun getTheAppDetailsIntent(packageName: String): Intent {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    return intent
}