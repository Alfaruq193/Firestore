package com.varoo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.varoo.firestore.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()

        binding.btnResetPassword.setOnClickListener {

            val email = binding.inputEmail.text.toString()
            val edtEmail = binding.inputEmail

            if (email.isEmpty()) {
                edtEmail.error = "Email diperlukan"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edtEmail.error = "Email Tidak Valid"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    val i = Intent(this, LoginActivity::class.java)
                    Toast.makeText(applicationContext, "Email Verifikasi Telah Dikirim ke $email", Toast.LENGTH_SHORT).show()
                    startActivity(i)
                    finish()

                } else {
                    edtEmail.error = "${it.exception?.message}"
                    edtEmail.requestFocus()
                }
            }


        }
    }
}