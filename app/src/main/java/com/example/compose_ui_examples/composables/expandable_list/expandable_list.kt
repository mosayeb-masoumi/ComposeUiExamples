package com.example.compose_ui_examples.composables.expandable_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableList() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(
                    color = Color.Green.copy(alpha = 0.3f)
                )
                .padding(16.dp) ,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            ExpandableCard(title = "Country" ,
                description = "kjhfkksh kfjkhkhkf khhkjhrqkg kkjrhwkjhqgh khhkhqkwrh" +
                        "hhkfhkj kkhj kgwehgehghk hjkwhekhgkh lkhkhklehg " +
                        "khekhfjkh lklkhlehrg hhlhllh;qerw h;kqehrg")

            ExpandableCard(
                title = "City" ,
                description = "kjhfkksh kfjkhkhkf khhkjhrqkg kkjrhwkjhqgh khhkhqkwrh" +
                        "hhkfhkj kkhj kgwehgehghk hjkwhekhgkh lkhkhklehg " +
                        "khekhfjkh lklkhlehrg hhlhllh;qerw h;kqehrg"
            )

        }
    }


}

@Preview
@Composable
fun ExpandableListPreview() {
    ExpandableList()
}