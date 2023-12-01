package com.example.compose_ui_examples.composables.share_viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MySharedViewModel: ViewModel() {

    var person by mutableStateOf<PersonShareModel?>(null)
        private set

    fun addPerson (newPerson: PersonShareModel){
        person = newPerson;
    }
}