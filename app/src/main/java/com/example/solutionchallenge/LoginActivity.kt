package com.example.solutionchallenge

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    supportActionBar?.hide()
    editEmail = findViewById(R.id.et_email)
    editPassword = findViewById(R.id.et_password)
    btnLogin = findViewById(R.id.btn_logIn)
    btnSignUp = findViewById(R.id.btn_signUp)
    mAuth = FirebaseAuth.getInstance()
    btnSignUp.setOnClickListener {
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }

    btnLogin.setOnClickListener {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        login(email,password)
    }
}

    private fun login(email: String, password: String) {

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    val user = mAuth.currentUser
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }
    }
}