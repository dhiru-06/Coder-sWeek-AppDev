package com.app.day4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIncrement.setOnClickListener {
            Toast.makeText(this, "Incrementer app", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, incrementapp::class.java)
            startActivity(intent)
        }

        btnGrid.setOnClickListener{
            Toast.makeText(this, "Gridlayout", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Gridlayout::class.java)
            startActivity(intent)
        }


    }
}
