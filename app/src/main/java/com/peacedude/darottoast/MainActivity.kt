package com.peacedude.darottoast

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.peacedude.gdtoast.Darot
import com.peacedude.gdtoast.gdErrorToast
import com.peacedude.gdtoast.gdToast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Darot.getGdDrawableBackgrnd = R.drawable.gd_toast_bkgrnd
        val drawab = ContextCompat.getDrawable(this, R.drawable.ic_android_green_24dp)
//        gdToast(
//            "Error World Error WorldError WorldError WorldError World WorldError World WorldError World",
//            icon= drawab
//        )

    }

    fun click(view: View){
        gdToast(
            message =  "Testing toast here",
            icon = R.drawable.ic_android_green_24dp,
            backgroundColor = R.color.colorAccent,
            textColor = R.color.colorBlueDark,
            gravity = Gravity.TOP,
            textGravity = 20,
            x_Offset = 10,
            y_OffSet = 10,
            toastDuration = Toast.LENGTH_LONG
        )
    }
}
