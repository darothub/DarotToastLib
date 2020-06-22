package com.peacedude.gdtoast

import android.view.View

/**
 * Hide view
 *
 */
fun View.hide(){
    this.visibility = View.GONE
}

/**
 * Show view
 *
 */
fun View.show(){
    this.visibility = View.VISIBLE
}