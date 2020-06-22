package com.peacedude.gdtoast

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

fun Activity.getGdToastLayout(): View {
    val layout by lazy {
        LayoutInflater.from(this).inflate(
            R.layout.gdtoast_layout, findViewById(R.id.toast_layout_vg)
        )
    }
    return layout
}
fun Activity.messageConstraint(text:TextView, message: String){
    if (message.length > 22){
        text.setEms(22)
    }
}
fun Activity.gdToast(message: String, gravity: Int) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()
    text.setTextColor(Color.BLACK)

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdToast(message: String, gravity: Int, xOffset: Int, yOffSet: Int) {

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

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, xOffset, yOffSet)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun Activity.gdToast(message: String, @DrawableRes icon: Int, gravity: Int? = null) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(icon, theme))
        text.setTextColor(resources.getColor(R.color.colorPrimary, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(R.color.colorPrimary))
    }

    messageConstraint(text, message)
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

fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Int,
    gravity: Int? = null
) {

    val layout = getGdToastLayout()
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(icon, theme))
        container.setBackgroundColor(resources.getColor(backgroundColor, theme))
        text.setTextColor(resources.getColor(R.color.colorPrimary, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(R.color.colorPrimary))
        container.setBackgroundColor(resources.getColor(backgroundColor))
    }

    messageConstraint(text, message)
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

fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
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

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(icon, theme))
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(textColor))
        container.background = gdToastDrawableBackground
    }

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = toastDuration
        view = layout
        show()
    }
}

fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
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
        image.setImageDrawable(resources.getDrawable(icon, theme))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor, theme), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(textColor))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
    }

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = toastDuration
        view = layout
        show()
    }
}
fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
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
        image.setImageDrawable(resources.getDrawable(icon, theme))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor, theme), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(textColor))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
    }

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, x_Offset, y_OffSet)
        duration = toastDuration
        view = layout
        show()
    }
}

fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Int,
    @ColorRes textColor: Int,
    gravity: Int,
    textGravity: Int,
    x_Offset: Int,
    y_OffSet: Int,
    toastDuration:Int

) {

    val layout = getGdToastLayout()
    val gdToastDrawableBackground = getDrawable(R.drawable.gd_toast_bkgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)

    text.gravity = textGravity

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        image.setImageDrawable(resources.getDrawable(icon, theme))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor, theme), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
        text.setTextColor(resources.getColor(textColor, theme))
    } else {
        image.setImageDrawable(resources.getDrawable(icon))
        text.setTextColor(resources.getColor(textColor))
        gdToastDrawableBackground?.colorFilter =
            PorterDuffColorFilter(resources.getColor(backgroundColor), PorterDuff.Mode.SRC_IN)
        container.background = gdToastDrawableBackground
    }

    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, x_Offset, y_OffSet)
        duration = toastDuration
        view = layout
        show()
    }
}