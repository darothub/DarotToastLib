package com.peacedude.gdtoast

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Toast error message
 *
 * @param message
 * @param gravity
 */
fun Activity.gdErrorToast(message: String, gravity: Int) {

    val layout = getGdToastLayout
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()
    text.setTextColor(Color.WHITE)
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    container.background = gdToastDrawableBackground

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}


/**
 * Toast error message
 *
 * @param message
 * @param gravity
 * @param coordinates
 */
fun Activity.gdErrorToast(message: String, gravity: Int, coordinates: Pair<Int, Int>) {

    val layout = getGdToastLayout
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    container.background = gdToastDrawableBackground
    text.setTextColor(Color.WHITE)

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, coordinates.first, coordinates.second)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(message: String, icon: Int, gravity: Int) {

    val layout = getGdToastLayout
    val text: TextView = layout.findViewById(R.id.toast_text)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    container.background = gdToastDrawableBackground
    text.setTextColor(Color.WHITE)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(icon, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
    }

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 0)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}


