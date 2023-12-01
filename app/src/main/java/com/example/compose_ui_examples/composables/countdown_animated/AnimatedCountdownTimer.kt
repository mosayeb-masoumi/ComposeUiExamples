package com.example.compose_ui_examples.composables.countdown_animated


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AnimatedCountdownTimer(private val coroutineScope: CoroutineScope) {

    private val animatableScale = Animatable(1f)
    private val animatableAlpha = Animatable(1f)

    val scale: Float get() = animatableScale.value
    val alpha: Float get() = animatableAlpha.value

    fun start(
        initialValue: Int,
        endValue: Int,
        onChange:(Int) -> Unit
    ) {

        var value = initialValue
        coroutineScope.launch {
            while (value > endValue -1){
                onChange(value)
                animatableScale.snapTo(1f)
                animatableAlpha.snapTo(1f)
                animatableScale.animateTo(2f, animationSpec = tween(750))

//               to keep last number scaled you can use it like this
                if (value > endValue) {
                    animatableAlpha.animateTo(0f, animationSpec = tween(250))
                }
//                animatableAlpha.animateTo(0f, animationSpec = tween(250))
                value--
            }
        }

    }

}