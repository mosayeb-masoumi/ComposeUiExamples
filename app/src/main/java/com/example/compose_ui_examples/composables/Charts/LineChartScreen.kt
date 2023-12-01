package com.example.compose_ui_examples.composables.Charts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import co.yml.charts.axis.AxisData
//import co.yml.charts.common.model.Point
//import co.yml.charts.ui.linechart.LineChart
//import co.yml.charts.ui.linechart.model.GridLines
//import co.yml.charts.ui.linechart.model.IntersectionPoint
//import co.yml.charts.ui.linechart.model.Line
//import co.yml.charts.ui.linechart.model.LineChartData
//import co.yml.charts.ui.linechart.model.LinePlotData
//import co.yml.charts.ui.linechart.model.LineStyle
//import co.yml.charts.ui.linechart.model.LineType
//import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
//import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
//import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
fun LineChartScreen() {

//    val steps = 5
//
//    val pointsData = listOf(
//        Point(0f, 40f),
//        Point(1f, 90f),
//        Point(2f, 0f),
//        Point(3f, 60f),
//        Point(4f, 10f)
//    )
//
//    val xAxisData = AxisData.Builder()
//        .axisStepSize(100.dp)
//        .backgroundColor(Color.Transparent)
//        .steps(pointsData.size - 1)
//        .labelData { i -> i.toString() }
//        .labelAndAxisLinePadding(15.dp)
//        .axisLineColor(MaterialTheme.colorScheme.tertiary)
//        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
//        .build()
//
//    val yAxisData = AxisData.Builder()
//        .backgroundColor(Color.Transparent)
//        .steps(steps)
//        .labelData { i ->
//            val yScale = 100 / steps
//            (i * yScale).toString()
//        }
//        .labelAndAxisLinePadding(20.dp)
//        .axisLineColor(MaterialTheme.colorScheme.tertiary)
//        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
//        .build()
//
//
//
//
//    val lineChartData = LineChartData(
//        linePlotData = LinePlotData(
//            lines = listOf(
//                Line(
//                    dataPoints = pointsData,
//                    lineStyle = LineStyle(
//                        color = MaterialTheme.colorScheme.tertiary,
//                        lineType = LineType.SmoothCurve(isDotted = false)
//                    ),
//                    intersectionPoint = IntersectionPoint(
//                        color = MaterialTheme.colorScheme.tertiary
//                    ),
//                    selectionHighlightPoint = SelectionHighlightPoint(
//                        color = MaterialTheme.colorScheme.tertiary
//                    ),
//                    shadowUnderLine = ShadowUnderLine(
//                        alpha = 0.5f,
//                        brush = Brush.verticalGradient(
//                            colors = listOf(
//                                MaterialTheme.colorScheme.tertiary,
//                                Color.Transparent
//                            )
//                        )
//                    ),
//
//                    selectionHighlightPopUp = SelectionHighlightPopUp()
//                )
//            )
//        ),
//
//        backgroundColor = MaterialTheme.colorScheme.surface,
//        xAxisData = xAxisData,
//        yAxisData = yAxisData,
//        gridLines = GridLines(color = MaterialTheme.colorScheme.outlineVariant)
//    )
//
//
//    LineChart(modifier = Modifier
//        .width(450.dp)
//        .height(300.dp),
//        lineChartData = lineChartData
//    )

}


@Preview
@Composable
fun LineChartScreenPreview() {
    LineChartScreen()
}