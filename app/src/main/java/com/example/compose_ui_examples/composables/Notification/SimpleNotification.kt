package com.example.compose_ui_examples.composables.Notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.compose_ui_examples.MainActivity
import com.example.compose_ui_examples.R


@Composable
fun SimpleNotification() {

    var showNotif by remember { mutableStateOf(false) }

    var showBigNotification by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                showNotif = true

            }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Blue.copy(alpha = 0.5f)
            ),
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(text = "show notification", fontSize = 20.sp)
        }



        Button(
            onClick = {
             showBigNotification = true
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Blue
            )
        ) {
            Text(text = "show Big Notification", fontSize = 20.sp)
        }



        if (showNotif) {
            ShowNotification()
            showNotif = false
        }

        if(showBigNotification){
            ShowBigNotification()
            showBigNotification = false
        }

    }
}


@Composable
fun ShowNotification() {

    val context = LocalContext.current
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createNotificationChannel(context)
    }
    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

    val builder = NotificationCompat.Builder(context, "my_channel_id")
        .setSmallIcon(R.drawable.ic_bell)
        .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bad_habits))
        .setContentTitle("My Notification Title")
        .setContentText("My Notification Text")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(context)) {
        // notificationId is a unique int for each notification that you must define
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        val notificationId = System.currentTimeMillis().toInt()
        notify(notificationId, builder.build())
    }
}


@RequiresApi(Build.VERSION_CODES.O)
private fun createNotificationChannel(context: Context) {
    val name = "My Channel"
    val descriptionText = "My channel description"
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel("my_channel_id", name, importance).apply {
        description = descriptionText
    }
    val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}



@Composable
fun ShowBigNotification(){

    val context = LocalContext.current
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createNotificationChannel(context)
    }
    val intent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

    val builder = NotificationCompat.Builder(context, "my_channel_id")
        .setSmallIcon(R.drawable.ic_bell)
        .setContentTitle("My Notification Title")
        .setContentText("My Notification Text")


        // these section of code is to set big picture in notification
        .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bad_habits))  // png/jpg/jpeg are ok

        .setStyle(NotificationCompat.BigPictureStyle()
            .bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.bad_habits))
//            .bigLargeIcon(null)
        )


//        .setStyle(NotificationCompat.BigTextStyle().bigText("This is a sample large notification. It can contain more text and be expanded to show additional content."))



        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(context)) {
        // notificationId is a unique int for each notification that you must define
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        val notificationId = System.currentTimeMillis().toInt()
        notify(notificationId, builder.build())
    }
}

