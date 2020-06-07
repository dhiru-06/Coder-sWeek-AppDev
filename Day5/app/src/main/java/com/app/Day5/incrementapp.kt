package com.app.Day5

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class incrementapp: AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incrementapp)
    }

    fun tap(view: View) {

        count++

        val text = findViewById(R.id.text) as TextView
        text.text = "$count"
    }

}