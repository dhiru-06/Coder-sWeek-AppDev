package com.app.Day5

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mAuthListner: FirebaseAuth.AuthStateListener? = null

    private var email: EditText? = null
    private var password: EditText? = null
    private var login: Button? = null
    private var signup: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        email = findViewById<View>(R.id.usernamee) as EditText
        password = findViewById<View>(R.id.password) as EditText
        login = findViewById<View>(R.id.login) as Button
        signup = findViewById<View>(R.id.sign) as Button

        mAuth = FirebaseAuth.getInstance()
        mAuthListner = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val User = firebaseAuth.currentUser

            if (User != null) {
                Log.d(TAG, "user is signed in")
            } else {
                Log.d(TAG, "User is not signed in")
            }
        }

        login!!.setOnClickListener {
            val emailString = email!!.text.toString()
            val Password = password!!.text.toString()

            if (emailString != "" && Password != "") {
                mAuth!!.signInWithEmailAndPassword(emailString, Password)
                        .addOnCompleteListener(this@MainActivity) { task ->
                            if (!task.isSuccessful) {
                                Toast.makeText(this@MainActivity, "Log in Failed", Toast.LENGTH_LONG)
                                        .show()

                            } else {
                                Toast.makeText(this@MainActivity, "Log in Successful", Toast.LENGTH_LONG)
                                        .show()
                                startActivity(Intent(this@MainActivity, menu::class.java))
                            }
                        }
            }
        }

        signup!!.setOnClickListener {
            val emailString = email!!.text.toString()
            val pwd = password!!.text.toString()
            if (emailString != "" && pwd != "") {
                mAuth!!.createUserWithEmailAndPassword(emailString, pwd).addOnCompleteListener(this@MainActivity
                ) { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(this@MainActivity, "Signed i Failed", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@MainActivity, "Signed in Successful", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener(mAuthListner!!)
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListner != null) {
            mAuth!!.addAuthStateListener(mAuthListner!!)
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }

}
