package  com.north.pacific.ocean.wave.utils

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView

fun splashAnimation(appIcon: ImageView, appTitle: TextView, appSubTitle: TextView, listener: Animator.AnimatorListener) {
    try {
        val ofFloat = ObjectAnimator.ofFloat(appIcon, "scaleX", 0.4f, 1.2f, 1.0f)
        ofFloat.duration = 1600
        val ofFloat2 = ObjectAnimator.ofFloat(appIcon, "scaleY", 0.4f, 1.2f, 1.0f)
        ofFloat2.duration = 1600
        val ofFloat3 = ObjectAnimator.ofFloat(
            appTitle,
            "translationY",
            100.0f, 0.0f
        )
        ofFloat3.duration = 700
        val ofFloat4 = ObjectAnimator.ofFloat(appTitle, "alpha", 0.0f, 1.0f)
        ofFloat4.duration = 700
        val ofFloat5 = ObjectAnimator.ofFloat(
            appSubTitle,
            "translationY",
            100.0f, 0.0f
        )
        ofFloat5.duration = 700
        val ofFloat6 = ObjectAnimator.ofFloat(appSubTitle, "alpha", 0.0f, 1.0f)
        ofFloat6.duration = 700
        val animatorSet = AnimatorSet()
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.play(ofFloat).with(ofFloat2)
        animatorSet.play(ofFloat3).after(ofFloat)
        animatorSet.play(ofFloat3).with(ofFloat4)
        animatorSet.play(ofFloat5).after(ofFloat3)
        animatorSet.play(ofFloat5).with(ofFloat6)
        animatorSet.start()
        animatorSet.addListener(listener)
    } catch (_: Exception) {
    }
}
