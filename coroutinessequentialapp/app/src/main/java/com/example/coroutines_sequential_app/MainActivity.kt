package com.example.coroutines_sequential_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("TAG", "The App has started")
            val a = doSomething()
            val b = doSomething2()
            val c = async { doSomething3() }
            val d = async { doSomething4() }

            val result = a + b
            Log.i("TAG", "The result is $result")

            val asyncResult = c.await() + d.await()
            Log.i("TAG", "The async result is $asyncResult")
        }
    }

    suspend fun doSomething(): Int {
        delay(5000)
        Log.i("TAG", "fun1 is done")
        return 11
    }


    suspend fun doSomething2(): Int {
        delay(5000)
        Log.i("TAG", "fun2 is done")
        return 9
    }


    suspend fun doSomething3(): Int {
        delay(15000)
        Log.i("TAG", "fun3 is done")
        return 30
    }


    suspend fun doSomething4(): Int {
        delay(15000)
        Log.i("TAG", "fun4 is done")
        return 30
    }
}