package com.example.compose_ui_examples.composables.language

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.LocaleListCompat
import com.example.compose_ui_examples.R
import java.util.Locale

@Composable
fun LanguageChange() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    var currentLocale by remember { mutableStateOf(Locale.getDefault()) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = stringResource(id = R.string.hello))
        Row(horizontalArrangement = Arrangement.SpaceBetween){

            Button(onClick = {
              changeLocale(context , configuration ,"fa", currentLocale ){ newLocale ->
                  currentLocale = newLocale
              }
            }) {
                Text(text = "فارسی")
            }

            Button(onClick = {
                changeLocale(context ,configuration,"en" ,currentLocale){
                    currentLocale = it
                }
            }) {
                Text(text = "English")
            }
        }
    }
}


fun changeLocale(
    context: Context,
    configuration: Configuration,
    localeString: String ,
    currentLocale: Locale,
    onUpdateLocale: (Locale) -> Unit
    ){

    val newLocale = Locale(localeString)
    if(currentLocale !=newLocale){
        Locale.setDefault(newLocale)
        var configuration = context.resources.configuration
        configuration.setLocale(newLocale)
        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
        // Update the MutableState to trigger recomposition
        onUpdateLocale(newLocale)
    }


//    val locale = Locale(localeString)
//    Locale.setDefault(locale)
//    configuration.setLocale(locale)
//    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)

    // recomposition must do to change text
}