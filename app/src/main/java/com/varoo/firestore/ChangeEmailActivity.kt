package com.varoo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.varoo.firestore.databinding.ActivityChangeEmailBinding
import com.varoo.firestore.user.UserFragment

class ChangeEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangeEmailBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()

        val user = auth.currentUser

        binding.btnUbahEmail.setOnClickListener {
            val oldEmail = binding.oldEmail.text.toString()
            val password = binding.password.text.toString()
            val newEmail = binding.newEmail.text.toString()

            if (oldEmail.isEmpty()) {
                binding.oldEmail.error = "Email Tidak Boleh Kosong !!"
                binding.oldEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.password.error = "Password Tidak Boleh Kosong !!"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            if (newEmail.isEmpty()) {
                binding.newEmail.error = "New Email Tidak Boleh Kosong !!"
                binding.newEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(oldEmail).matches()) {
                binding.oldEmail.error = "Email Tidak Valid!"
                binding.oldEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()) {
                binding.newEmail.error = "Email Tidak Valid!"
                binding.newEmail.requestFocus()
                return@setOnClickListener
            }

            user.let {
                val userCredential = EmailAuthProvider.getCredential(it?.email!!, password)
                it.reauthenticate(userCredential).addOnCompleteListener { Task ->
                    when {
                        Task.isSuccessful -> {
                            user.let {
                                it?.updateEmail(newEmail)?.addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        val i = Intent(this, UserFragment::class.java)
                                        Toast.makeText(
                                            this,
                                            "Email Berhasil Di Ganti ",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        startActivity(i)
                                        finish()

                                    }
                                }
                            }
                        }
                        Task.exception is FirebaseAuthInvalidCredentialsException -> {
                            binding.password.error = "Password Salah"
                            binding.password.requestFocus()
                            binding.oldEmail.error = "Email Tidak Cocok"
                            binding.oldEmail.requestFocus()
                        }
                        else -> {
                            Toast.makeText(this, "${Task.exception?.message}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

            }
        }
    }
}