package com.varoo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.varoo.firestore.databinding.ActivityChangePasswordBinding
import com.varoo.firestore.user.UserFragment


class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser


        binding.btnUbahPassword.setOnClickListener {
            val password = binding.oldPass.text.toString()
            val newPassword = binding.newPass.text.toString()
            val confPassword = binding.passConf.text.toString()

            if (password.isEmpty()) {
                binding.oldPass.error = "Password Tidak Boleh Kosong !!"
                binding.oldPass.requestFocus()
                return@setOnClickListener
            }
            if (newPassword.isEmpty()) {
                binding.newPass.error = "New Password Tidak Boleh Kosong !!"
                binding.newPass.requestFocus()
                return@setOnClickListener
            }
            if (confPassword.isEmpty()) {
                binding.passConf.error = "Password Confirmation Tidak Boleh Kosong !!"
                binding.passConf.requestFocus()
                return@setOnClickListener
            }
            if (newPassword != confPassword) {
                binding.passConf.error = "Password Cornfirmation Harus Sama !!"
                binding.passConf.requestFocus()
                return@setOnClickListener
            }

            user.let {
                val userCredential = EmailAuthProvider.getCredential(it?.email!! , password)
                it.reauthenticate(userCredential).addOnCompleteListener { Task ->
                    when {
                        Task.isSuccessful -> {
                            user.let {
                                it?.updatePassword(newPassword)?.addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        val i = Intent(this,UserFragment::class.java)
                                        Toast.makeText(
                                            this,
                                            "Password Berhasil Di Ganti ",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        startActivity(i)
                                        finish()

                                    }
                                }
                            }
                        }
                        Task.exception is FirebaseAuthInvalidCredentialsException -> {
                            binding.oldPass.error = "Password Salah"
                            binding.oldPass.requestFocus()
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