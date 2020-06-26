package com.peacedude.darottoast

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.peacedude.gdtoast.gdToast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gdToast(
            message = "Hello World",
            icon = R.drawable.ic_android_green_24dp,
            backgroundColor = R.color.newColor,
            textColor = R.color.colorPrimaryDark,
            gravity = Gravity.TOP,
            textGravity = Gravity.START,
            x_Offset = 10,
            y_OffSet = 20,
            toastDuration = Toast.LENGTH_SHORT
        )
    }
}
