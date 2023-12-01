package com.example.compose_ui_examples.composables.broadcast_gps

import android.content.Context
import android.content.IntentFilter
import android.location.LocationManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun BroadcastGpsScreen() {

    val context = LocalContext.current
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    // State to hold GPS status
    var isGpsEnabled by remember { mutableStateOf(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) }


    // Register broadcast receiver when the Composable is active
    val gpsStatusReceiver = rememberUpdatedState(GpsStatusReceiver {
        isGpsEnabled = it
    })


    DisposableEffect(Unit) {
        val intentFilter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        context.registerReceiver(gpsStatusReceiver.value, intentFilter)

        // Unregister the receiver when the Composable is disposed
        onDispose {
            context.unregisterReceiver(gpsStatusReceiver.value)
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = if(isGpsEnabled) "gps is ON" else "gps is OFF")
    }

}