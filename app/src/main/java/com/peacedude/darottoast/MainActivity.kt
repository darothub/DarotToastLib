package com.peacedude.darottoast

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.peacedude.gdtoast.Darot
import com.peacedude.gdtoast.gdErrorToast
import com.peacedude.gdtoast.gdToast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Darot.getGdDrawableBackgrnd = R.drawable.gd_toast_bkgrnd

        gdErrorToast("Error World", Gravity.TOP)
    }
}
