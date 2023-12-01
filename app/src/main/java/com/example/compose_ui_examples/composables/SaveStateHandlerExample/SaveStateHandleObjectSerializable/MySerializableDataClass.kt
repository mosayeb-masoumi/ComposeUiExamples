package com.example.compose_ui_examples.composables.SaveStateHandlerExample.SaveStateHandleObjectSerializable

import java.io.Serializable


data class MySerializableDataClass(
    var name: String = "",
    val age: Int = 0
) : Serializable
