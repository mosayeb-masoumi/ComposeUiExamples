package com.example.compose_ui_examples.composables.Charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import co.yml.charts.axis.AxisData
//import co.yml.charts.axis.DataCategoryOptions
//import co.yml.charts.common.model.Point
//import co.yml.charts.common.utils.DataUtils
//import co.yml.charts.ui.barchart.BarChart
//import co.yml.charts.ui.barchart.models.BarChartData
//import co.yml.charts.ui.barchart.models.BarChartType
//import co.yml.charts.ui.barchart.models.BarData

@Composable
fun BarChartScreen() {

//    val stepSize = 5
//
//    val barsData = listOf(
//        BarData(
//            point = Point(0f , 40f),
//            color = Color.Blue,
//            label = "label 0",
//            dataCategoryOptions = DataCategoryOptions(),
//            description = "description"
//        ),
//
//        BarData(
//            point = Point(1f , 70f),
//            color = Color.Green,
//            label = "label 0",
//            dataCategoryOptions = DataCategoryOptions(),
//            description = "description"
//        ),
//
//        BarData(
//            point = Point(2f , 20f),
//            color = Color.Red,
//            label = "label 0",
//            dataCategoryOptions = DataCategoryOptions(),
//            description = "description"
//        ),
//
//        BarData(
//            point = Point(3f , 60f),
//            color = Color.Black,
//            label = "label 0",
//            dataCategoryOptions = DataCategoryOptions(),
//            description = "description"
//        ),
//    )
//
//    val xAxisData = AxisData.Builder()
//        .axisStepSize(30.dp)
//        .steps(barsData.size - 1)
//        .bottomPadding(40.dp)
//        .axisLabelAngle(20f)
//        .labelData { index -> barsData[index].label }
//        .axisLineColor(MaterialTheme.colorScheme.tertiary)
//        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
//        .build()
//
//    val yAxisData = AxisData.Builder()
//        .steps(stepSize)
//        .labelAndAxisLinePadding(20.dp)
//        .axisOffset(20.dp)
//        .labelData { index -> (index * (100 / stepSize)).toString() }
//        .axisLineColor(MaterialTheme.colorScheme.tertiary)
//        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
//        .build()
//
//
//    val barChartData = BarChartData(
//        chartData = barsData,
//        xAxisData = xAxisData,
//        yAxisData = yAxisData,
//        backgroundColor = MaterialTheme.colorScheme.surface
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(400.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        BarChart(
//            modifier = Modifier
//                .height(350.dp)
//                .width(400.dp),
//            barChartData = barChartData
//        )
//    }

}

@Preview
@Composable
fun BarChartScreenPreview() {
    BarChartScreen()
}