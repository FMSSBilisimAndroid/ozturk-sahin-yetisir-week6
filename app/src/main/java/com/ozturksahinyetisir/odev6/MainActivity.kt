package com.ozturksahinyetisir.odev6

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * While loop used. if (x > 0) & x++
         * Test log starts when while returns but IO always take first priority.
         * On this log view always Dispatchers.IO more effective about with priority.
         * Without loop Log answer & Dispatchers.Main works well.
         */
        var x = 1
    while (x>0){
        Log.v("PATIKA","test")
        CoroutineScope(Dispatchers.IO).launch {
            Log.v("PATIKA","Dispatchers.IO")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.v("PATIKA",answer)
                Log.v("PATIKA","Dispatchers.Main")
                x++
            }
        }
        }
    }

    /**
     * [doNetworkCall] delay 2000 ms & return "Network Answer Called"
     */
        suspend fun doNetworkCall():String {
            delay(2000L)
            return "Network Answer Called "
    }
}