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


fun Activity.gdErrorToast(message: String, gravity: Int) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()
    text.setTextColor(Color.WHITE)
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)


    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    container.background = gdToastDrawableBackground

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 0)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(message: String, gravity: Int, xOffset: Int, yOffSet: Int) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        text.setTextColor(resources.getColor(R.color.colorPrimary, theme))
    } else {
        text.setTextColor(resources.getColor(R.color.colorPrimary))
    }

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, xOffset, yOffSet)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(message: String, @DrawableRes logo: Int, gravity: Int? = null) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))
        text.setTextColor(resources.getColor(R.color.colorPrimary, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(R.color.colorPrimary))
    }

    text.text = message
    with(Toast(this)) {
        when {
            gravity != null -> setGravity(gravity, 0, 0)
            else -> setGravity(Gravity.BOTTOM, 0, 0)
        }

        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(
    message: String,
    @DrawableRes logo: Int,
    @ColorRes backgroundColor: Int,
    gravity: Int? = null
) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))
        container.setBackgroundColor(resources.getColor(backgroundColor, theme))
        text.setTextColor(resources.getColor(R.color.colorPrimary, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(R.color.colorPrimary))
        container.setBackgroundColor(resources.getColor(backgroundColor))
    }

    text.text = message
    with(Toast(this)) {
        when {
            gravity != null -> setGravity(gravity, 0, 0)
            else -> setGravity(Gravity.BOTTOM, 0, 0)
        }

        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(
    message: String,
    @DrawableRes logo: Int,
    backgroundColor: String,
    @ColorRes textColor: Int,
    gravity: Int,
    toastDuration:Int
) {

    val layout = getGdToastLayout()
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)


    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.parseColor(backgroundColor), PorterDuff.Mode.SRC_IN)
    container.background = gdToastDrawableBackground
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))

        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(textColor))
    }

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = toastDuration
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(
    message: String,
    @DrawableRes logo: Int,
    backgroundColor: String,
    @ColorRes textColor: Int,
    gravity: Int,
    x_Offset:Int,
    y_OffSet: Int,
    toastDuration:Int
) {

    val layout = getGdToastLayout()
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)


    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(Color.parseColor(backgroundColor), PorterDuff.Mode.SRC_IN)

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(textColor))
        container.background = gdToastDrawableBackground
    }

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, x_Offset, y_OffSet)
        duration = toastDuration
        view = layout
        show()
    }
}

fun Activity.gdErrorToast(
    message: String,
    @DrawableRes logo: Int,
    @ColorRes backgroundColor: Int,
    @ColorRes textColor: Int,
    gravity: Int,
    toastDuration:Int
) {

    val layout = getGdToastLayout()
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)


    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor, theme), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(textColor))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
    }

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = toastDuration
        view = layout
        show()
    }
}
fun Activity.gdErrorToast(
    message: String,
    @DrawableRes logo: Int,
    @ColorRes backgroundColor: Int,
    @ColorRes textColor: Int,
    gravity: Int,
    x_Offset: Int,
    y_OffSet: Int,
    toastDuration:Int
) {

    val layout = getGdToastLayout()
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)


    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(logo, theme))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor, theme), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(logo))
        text.setTextColor(resources.getColor(textColor))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
    }

    text.text = message
    with(Toast(this)) {
        setGravity(gravity, x_Offset, y_OffSet)
        duration = toastDuration
        view = layout
        show()
    }
}