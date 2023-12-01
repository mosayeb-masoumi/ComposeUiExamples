package com.example.compose_ui_examples.composables.sharepreference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharePreference(private val context: Context) {

    companion object{
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("project_pref")

        // items
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")

        val PERMISSION_COUNTER_KEY = intPreferencesKey("permission_deny")
        // here add other keys
     }


    // get email
    val getEmail: Flow<String?> = context.datastore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

   // setEmail
    suspend fun setEmail(name:String){
        context.datastore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }



    // get email
    val getPermissionDenyCounter: Flow<Int?> = context.datastore.data
        .map { preferences ->
            preferences[PERMISSION_COUNTER_KEY] ?: 0
        }

    // setEmail
    suspend fun setPermissionDenyCounter(counter:Int){
        context.datastore.edit { preferences ->
            preferences[PERMISSION_COUNTER_KEY] = counter
        }
    }

}