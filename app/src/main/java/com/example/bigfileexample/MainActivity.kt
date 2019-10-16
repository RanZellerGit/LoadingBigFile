package com.example.bigfileexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStreamReader
import kotlin.text.Charsets.UTF_8


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            benchmark(::loadJSONFromAsset)
        }
    }

    fun loadJSONFromAsset(): DataHolder? {
        var json: DataHolder? = null
        try {
            val inputStream = assets.open("bigFile.json")
            val reader = JsonReader(InputStreamReader(inputStream, UTF_8))
            val gson = Gson()
            json = gson.fromJson(reader, DataHolder::class.java)
            print("RANZZ ${json?.data?.size}\n")

        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return json
    }

    fun benchmark(f: () -> Any?) {
        System.gc()
        val startTime = System.currentTimeMillis()
        val startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()

        f.invoke()

        System.gc()
        val finishTime = System.currentTimeMillis()
        val finishMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()

        val elapsedMemory = finishMemory - startMemory
        val elapsedTime = finishTime - startTime

        textView.setText("Elapsed time: $elapsedTime\n Used memory: $elapsedMemory")

        println("RANZZ Elapsed time: $elapsedTime")
        println("RANZZ Used memory: $elapsedMemory")
    }
}
