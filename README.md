# DarotToastLib

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/darothub/darotToastLib.svg)](https://jitpack.io/#darothub/darotToastLib)

The library is a flexible implementation of toast message display in android application development. It allows almost full customization
of displaying a toast message including changing the background drawable, text color to mention few.

![Screenshot](app/src/main/res/mipmap-xxxhdpi/Screenshot.png)

# Gradle

 ```kotlin
  implementation 'com.github.darothub:DarotToastLib:version'
 ```
 # Simple usage in an activity
 ```kotlin
     gdToast("Hello World!", Gravity.CENTER)
 ```
 ## Show toast with resource drawable icon
 ```kotlin
     gdToast("Hello World", R.drawable.ic_android_green_24dp, Gravity.BOTTOM)
 ```
 ## Show toast with preferred coordinates ```Pair(x, y)```
 ```kotlin
     gdToast("Hello World", Gravity.CENTER, Pair(0, 20))
 ```
 ## Show toast with resource background color
 ```kotlin
     gdToast("Hello World",R.drawable.ic_android_green_24dp, R.color.newColor, Gravity.BOTTOM)
 ```
 ## Show toast with any drawable derived icon
 ```kotlin
     gdToast("Hello World", getDrawable(R.drawable.ic_android_green_24dp))
 ```
 ## Show toast with string background color
 ```kotlin
      gdToast(
            message = "Hello World",
            icon = R.drawable.ic_android_green_24dp,
            backgroundColor = "#000000",
            textColor = R.color.newColor,
            gravity = Gravity.CENTER,
            toastDuration = Toast.LENGTH_LONG
        )
 ```
  ## Show toast with preferred position
 ```kotlin
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
 ```
# Simple usage in a fragment
 ```kotlin
  requireActivity.gdToast("Hello World!", Gravity.CENTER)
 ```
# License

 ```
   Copyright 2020 Durosomo Abdulrasaq Darot

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ```

