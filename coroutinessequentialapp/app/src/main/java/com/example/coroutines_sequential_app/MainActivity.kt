package com.example.coroutines_sequential_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            val a = doSomething()
            val b = doSomething2()

            val result = a + b
            Log.i("TAG","The result is $result")
        }
    }

    suspend fun doSomething():Int{
        delay(5000)
        Log.i("TAG","fun1 is done")
        return 11
    }


    suspend fun doSomething2():Int{
        delay(12000)
        Log.i("TAG","fun2 is done")
        return 9
    }
}