package com.armanco.codern.utils.extension

import android.util.Log
import com.google.gson.Gson

fun Any.log(message: Any?, tag: String? = null) {
    val gson = Gson()
    Log.d("${hashCode()}/${javaClass.simpleName}${if(tag!=null) "/$tag" else ""}", if(message is String) message else gson.toJson(message))
}
