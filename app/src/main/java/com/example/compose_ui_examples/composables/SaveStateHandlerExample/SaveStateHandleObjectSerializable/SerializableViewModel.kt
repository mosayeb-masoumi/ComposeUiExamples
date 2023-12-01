package com.example.compose_ui_examples.composables.SaveStateHandlerExample.SaveStateHandleObjectSerializable

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.Serializable

class SerializableViewModel(private  val savedStateHandle: SavedStateHandle): ViewModel() {

    private val KEY_DATA = "key_data"

    fun saveData(data: MySerializableDataClass){
        savedStateHandle.set(KEY_DATA, data as Serializable)
    }

    val getSavedData : MySerializableDataClass? get() = savedStateHandle.get<MySerializableDataClass>(KEY_DATA)


    init {

        getValues()
    }

    fun getValues(): Flow<String> = flow {

        for(i in 1..5){
            delay(1000L)
            emit("value $i")
            delay(3000)
        }
    }.conflate()
}
