package com.example.compose_ui_examples.composables.image_picker_camera_gallery

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.composables.permission.lackner.CameraPermissionTextProvider
import com.example.compose_ui_examples.composables.permission.lackner.MainViewModel
import com.example.compose_ui_examples.composables.permission.lackner.PermissionDialog
import com.example.compose_ui_examples.composables.permission.lackner.PhoneCallPermissionTextProvider
import com.example.compose_ui_examples.composables.permission.lackner.RecordAudioPermissionTextProvider
import com.example.compose_ui_examples.composables.permission.lackner.StoragePermissionTextProvider
import com.example.compose_ui_examples.composables.permission.second_example.ShowDialog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen() {


    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )


    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }


    val cameraLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }


    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) {
            if (it) {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp , vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Button(onClick = {
            val permissionCheckResult =
                ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)

            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                cameraLauncher.launch(uri)
            } else {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }

        }) {
            Text(text = "Capture image")
        }
    }

    if (capturedImageUri.path?.isNotEmpty() == true) {

        Image(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            painter = rememberImagePainter(data = capturedImageUri),
            contentDescription = null
        )
    } else {
        Image(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
    }
}

fun Context.createImageFile(): File {

    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )

    return image
}


//    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
//    var counter = remember{ mutableStateOf(0) }
//    val openSettings = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }
//
//
//
//    val showDialog = remember { mutableStateOf(false) }
//    val coroutineScope = rememberCoroutineScope()
//
//
//    val myMultiplePermissionState = rememberMultiplePermissionsState(
//        permissions = listOf(
//            Manifest.permission.CALL_PHONE,
//            Manifest.permission.RECORD_AUDIO,
//        )
//    )
//
//
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Button(onClick = {
//
//            if (myMultiplePermissionState.permissions[0].status.isGranted &&
//                myMultiplePermissionState.permissions[1].status.isGranted
//            ) {
//                // open camera
//            } else {
//
//                if (myMultiplePermissionState.permissions[0].status.shouldShowRationale
//                    && myMultiplePermissionState.permissions[1].status.shouldShowRationale
//                ) {
//                    counter.value ++
//                    //denied
//                } else {
//                    if (counter.value > 0) {  // show popup to open setting
//                        coroutineScope.launch {
//                            showDialog.value = true
//                        }
//                    }
//                    counter.value++
//                }
//                myMultiplePermissionState.launchMultiplePermissionRequest()
//            }
//        }) {
//            androidx.compose.material.Text(text = "multiple permission")
//        }
//
//    }
//
//
//    if (showDialog.value && !cameraPermissionState.status.shouldShowRationale) {
//        ShowDialog1(type = "permanently_denied", showDialog , openSettings)
//    }


//}


//@Composable
//fun ShowDialog1(
//    type: String,
//    showDialog: MutableState<Boolean>,
//    openSettings: ManagedActivityResultLauncher<Intent, ActivityResult>
//) {
//
//    val context = LocalContext.current
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 50.dp)
//            .background(color = Color.Gray)
//            .clip(RoundedCornerShape(30.dp))
//    ) {
//
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(all = 10.dp), horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//
//                androidx.compose.material.Text(text = "title")
//
//                Icon(
//                    Icons.Default.Close,
//                    contentDescription = "",
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clickable {
//                            showDialog.value = false
//                        })
//            }
//
//            androidx.compose.material.Text(
//                text = "user permanently denied the permission " +
//                        "to enable it goto setting "
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Divider(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(all = 20.dp),
//                color = Color.Gray,
//                thickness = 1.dp
//            )
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .padding(10.dp)
//                    .background(color = Color.Green)
//                    .clip(
//                        RoundedCornerShape(10.dp)
//                    )
//                    .clickable {
//
//
//                        openSettings.launch(
//                            getTheAppDetailsIntent1(context.packageName)
//                        )
//                        showDialog.value = false
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                androidx.compose.material.Text(
//                    text = "close",
//                    style = TextStyle(color = Color.White)
//                )
//            }
//
//        }
//    }
//}
//
//private fun getTheAppDetailsIntent1(packageName: String): Intent {
//    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//    val uri = Uri.fromParts("package", packageName, null)
//    intent.data = uri
//    return intent
//}











