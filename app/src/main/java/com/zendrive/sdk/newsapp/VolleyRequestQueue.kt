package com.zendrive.sdk.newsapp

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleyRequestQueue constructor(context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: VolleyRequestQueue? = null
        fun getInstance(context: Context): VolleyRequestQueue {
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: VolleyRequestQueue(context).also {
                    INSTANCE = it
                }
            }
            return INSTANCE!!
        }
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }
}
