package com.example.compose_ui_examples.composables.parcelable_example_save_state_handle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonParcelableModel(
    var firstName: String? ="",
    var lastName: String? ="",
):Parcelable
