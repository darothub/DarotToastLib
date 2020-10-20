package com.peacedude.gdtoast

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.CountDownTimer
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable


object Darot{
    var getGdDrawableBackgrnd = R.drawable.gd_toast_bkgrnd
}
fun Activity.changeDrawableBackgrnd(container:ViewGroup){
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    container.background = gdToastDrawableBackground
}
val Activity.getGdToastLayout: View
    get() {
        val layout by lazy {
            LayoutInflater.from(this).inflate(
                R.layout.gdtoast_layout, findViewById(R.id.toast_layout_vg)
            )
        }
        return layout
    }


/**
 * Set message constraint(limit)
 *
 * @param text
 * @param message
 */
fun Activity.messageConstraint(text: TextView, message: String) {
    if (message.length > 22) {
        text.setEms(20)
    }
}

/**
 * Shows simple toast message with
 *
 * @param message
 * @param gravity
 */
fun Activity.gdToast(message: String, gravity: Int) {

    val layout = getGdToastLayout
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    image.hide()
    text.setTextColor(Color.BLACK)
    changeDrawableBackgrnd(container)
    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param backgroundColor
 * @param gravity
 */

fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Int,
    gravity: Int? = null
) {

    val layout = getGdToastLayout
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    image.setImageDrawable(getDrawable(icon))
    text.setTextColor(ContextCompat.getColor(this, R.color.colorBlue))
    gdToastDrawableBackground?.colorFilter = PorterDuffColorFilter(
        ContextCompat.getColor( this, backgroundColor),
        PorterDuff.Mode.SRC_IN
    )
    container.background = gdToastDrawableBackground
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

/**
 * Shows simple toast message with
 *
 * @param message
 * @param gravity
 * @param xOffset
 * @param yOffSet
 */
fun Activity.gdToast(message: String, gravity: Int, coordinates: Pair<Int, Int>) {

    val layout = getGdToastLayout
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    changeDrawableBackgrnd(container)
    image.hide()
    text.setTextColor(ContextCompat.getColor(this, R.color.colorBlue))
    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, coordinates.first, coordinates.second)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param gravity
 */
fun Activity.gdToast(message: String, @DrawableRes icon: Int, gravity: Int) {

    val layout = getGdToastLayout
    val text: TextView = layout.findViewById(R.id.toast_text)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val image: ImageView = layout.findViewById(R.id.toast_icon)
    changeDrawableBackgrnd(container)
    image.setImageDrawable(getDrawable(icon))
    text.setTextColor(ContextCompat.getColor(this, R.color.colorBlue))
    messageConstraint(text, message)
    text.text = message
    with(Toast(this)) {
        setGravity(gravity, 0, 0)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}


/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param backgroundColor
 * @param textColor
 * @param gravity
 * @param toastDuration
 */
fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
    backgroundColor: String,
    textColor: Int,
    gravity: Int,
    toastDuration: Int
) {

    val layout = getGdToastLayout
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)


    gdToastDrawableBackground?.colorFilter =
        PorterDuffColorFilter(Color.parseColor(backgroundColor), PorterDuff.Mode.SRC_IN)
    image.setImageDrawable(getDrawable(icon))
    container.background = gdToastDrawableBackground
    text.setTextColor(ContextCompat.getColor(this, textColor))
    messageConstraint(text, message)
    text.text = message

    if (toastDuration != Toast.LENGTH_LONG || toastDuration != Toast.LENGTH_SHORT) {
        val toastCountDown = object : CountDownTimer(toastDuration.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                initToast(gravity, toastDuration, layout)
            }

            override fun onFinish() {}
        }

        initToast(gravity, toastDuration, layout)
        toastCountDown.start()
    }else{
        initToast(gravity, toastDuration, layout)
    }
}

private fun Activity.initToast(
    gravity: Int,
    toastDuration: Int,
    layout: View
) {
    with(Toast(this)) {
        setGravity(gravity, 0, 50)
        duration = toastDuration
        view = layout
        show()
    }
}


/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param backgroundColor
 * @param textColor
 * @param gravity
 * @param toastDuration
 */
fun Activity.gdToast(
    message: String,
    icon: Int,
    @ColorRes backgroundColor: Int,
    textColor: Int,
    gravity: Int,
    toastDuration: Int
) {

    val layout = getGdToastLayout
     val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)

    image.setImageDrawable(getDrawable(this, icon))
    gdToastDrawableBackground?.colorFilter =
        PorterDuffColorFilter(
            ContextCompat.getColor(this, backgroundColor),
            PorterDuff.Mode.SRC_IN
        )
    container.background = gdToastDrawableBackground
    text.setTextColor(ContextCompat.getColor(this, textColor))
    messageConstraint(text, message)
    text.text = message
    if (toastDuration != Toast.LENGTH_LONG || toastDuration != Toast.LENGTH_SHORT) {
        val toastCountDown = object : CountDownTimer(toastDuration.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                initToast(gravity, toastDuration, layout)
            }

            override fun onFinish() {}
        }

        initToast(gravity, toastDuration, layout)
        toastCountDown.start()
    }else{
        initToast(gravity, toastDuration, layout)
    }
}

/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param backgroundColor
 * @param textColor
 * @param gravity
 * @param x_Offset
 * @param y_OffSet
 * @param toastDuration
 */
fun Activity.gdToast(
    message: String,
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Int,
    textColor: Int,
    gravity: Int,
    x_Offset: Int,
    y_OffSet: Int,
    toastDuration: Int
) {

    val layout = getGdToastLayout
     val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)

    image.setImageDrawable(getDrawable(icon))
    gdToastDrawableBackground?.colorFilter =
        PorterDuffColorFilter(
            ContextCompat.getColor(this, backgroundColor),
            PorterDuff.Mode.SRC_IN
        )
    container.background = gdToastDrawableBackground
    text.setTextColor(ContextCompat.getColor(this, textColor))
    messageConstraint(text, message)
    text.text = message

    if (toastDuration != Toast.LENGTH_LONG || toastDuration != Toast.LENGTH_SHORT) {
        val toastCountDown = object : CountDownTimer(toastDuration.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                initToast(gravity, toastDuration, layout)
            }

            override fun onFinish() {}
        }

        initToast(gravity, toastDuration, layout)
        toastCountDown.start()
    }else{
        initToast(gravity, toastDuration, layout)
    }
}

/**
 * Shows simple toast message with
 *
 * @param message
 * @param icon
 * @param backgroundColor
 * @param textColor
 * @param gravity
 * @param textGravity
 * @param x_Offset
 * @param y_OffSet
 * @param toastDuration
 */
fun Activity.gdToast(
    message: String,
    icon: Int,
    backgroundColor: Int,
    textColor: Int,
    gravity: Int,
    textGravity: Int?,
    x_Offset: Int,
    y_OffSet: Int,
    toastDuration: Int

) {

    val layout = getGdToastLayout
    val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)

    if (textGravity != null) {
        text.gravity = textGravity
    }

    image.setImageDrawable(getDrawable(icon))
    gdToastDrawableBackground?.colorFilter =
        PorterDuffColorFilter(
            ContextCompat.getColor(this, backgroundColor),
            PorterDuff.Mode.SRC_IN
        )
    container.background = gdToastDrawableBackground
    text.setTextColor(ContextCompat.getColor(this, textColor))
    messageConstraint(text, message)
    text.text = message

    if (toastDuration != Toast.LENGTH_LONG || toastDuration != Toast.LENGTH_SHORT) {
        val toastCountDown = object : CountDownTimer(toastDuration.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                initToast(gravity, toastDuration, layout)
            }

            override fun onFinish() {}
        }

        initToast(gravity, toastDuration, layout)
        toastCountDown.start()
    }else{
        initToast(gravity, toastDuration, layout)
    }
}

fun Activity.gdToast(
    message: String,
    icon: Drawable?,
    backgroundColor: Int?=null,
    textColor: Int?=null,
    gravity: Int?=null,
    textGravity: Int?=null,
    x_Offset: Int = 0,
    y_OffSet: Int = 0,
    toastDuration: Int

) {

    val layout = getGdToastLayout
     val gdToastDrawableBackground = getDrawable(Darot.getGdDrawableBackgrnd)
    val container: ViewGroup = layout.findViewById(R.id.toast_layout_vg)
    val text: TextView = layout.findViewById(R.id.toast_text)
    val image: ImageView = layout.findViewById(R.id.toast_icon)

    if (textGravity != null) {
        text.gravity = textGravity
    }

    image.setImageDrawable(icon)
    when{
        backgroundColor != null -> {
            gdToastDrawableBackground?.colorFilter =
                PorterDuffColorFilter(
                    ContextCompat.getColor(this, backgroundColor),
                    PorterDuff.Mode.SRC_IN
                )}
        textColor != null -> text.setTextColor(ContextCompat.getColor(this, textColor))
        else ->{
            gdToastDrawableBackground?.colorFilter =
                PorterDuffColorFilter(
                    ContextCompat.getColor(this, R.color.colorBlue),
                    PorterDuff.Mode.SRC_IN
                )
            text.setTextColor(Color.BLACK)
        }
    }

    container.background = gdToastDrawableBackground

    messageConstraint(text, message)
    text.text = message




    if (toastDuration != Toast.LENGTH_LONG || toastDuration != Toast.LENGTH_SHORT) {
        val toastCountDown = object : CountDownTimer(toastDuration.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                initToastX(gravity, x_Offset, y_OffSet, toastDuration, layout)
            }

            override fun onFinish() {}
        }
        initToastX(gravity, x_Offset, y_OffSet, toastDuration, layout)
        toastCountDown.start()
    }else{
        initToastX(gravity, x_Offset, y_OffSet, toastDuration, layout)
    }
}

private fun Activity.initToastX(
    gravity: Int?,
    x_Offset: Int,
    y_OffSet: Int,
    toastDuration: Int,
    layout: View
) {
    with(Toast(this)) {
        when (gravity) {
            null -> {
                setGravity(Gravity.CENTER, x_Offset, y_OffSet)
            }
            else -> {
                setGravity(gravity, x_Offset, y_OffSet)
                duration = toastDuration.toInt()
            }
        }

        view = layout
        show()
    }
}

