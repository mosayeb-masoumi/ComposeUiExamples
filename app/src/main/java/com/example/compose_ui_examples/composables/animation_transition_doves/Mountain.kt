package com.example.compose_ui_examples.composables.animation_transition_doves

data class Mountain(
    val title:String ,
    val description: String,
    val image: String
)

val mountains = listOf(
    Mountain(
        title = "Chale ghooch",
        description = "chale ghooch placed in varazaneh \n chale ghooch placed in varazaneh",
        image = "https://shorturl.at/hjHV0"
    ),

    Mountain(
        title = "Sarab barzineh",
        description = "sarab barzineh placed in varazaneh \n sarab barzineh  placed in varazaneh",
        image = "https://shorturl.at/hjHV0"
    ),

    Mountain(
        title = "Vikoo",
        description = "vikoo placed in varazaneh \n vikoo placed in varazaneh",
        image = "https://shorturl.at/hjHV0"
    ),
)