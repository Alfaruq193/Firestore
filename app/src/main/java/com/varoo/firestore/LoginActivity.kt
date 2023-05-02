package com.varoo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.varoo.firestore.api.ApiConfig
import com.varoo.firestore.databinding.ActivityLoginBinding
import com.varoo.firestore.helper.SharedPreference
import com.varoo.firestore.model.ResponseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sPH: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            Login()
        }
        sPH = SharedPreference(this)


        binding.txtForgot.setOnClickListener {
            val i = Intent(this, ChangePasswordActivity::class.java)
            startActivity(i)
        }

        binding.sgnUp.setOnClickListener {
            val i = Intent(this, RegisActivity::class.java)
            startActivity(i)
        }

    }

    private fun Login() {
        val email = binding.emailLogin.text.toString()
        val pass = binding.passLogin.text.toString()

        if (email.isEmpty()) {
            binding.emailLogin.error = "Email harus diisi!"
            binding.emailLogin.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailLogin.error = "Email tidak valid!"
            binding.emailLogin.requestFocus()
            return
        }

        if (pass.isEmpty()) {
            binding.passLogin.error = "Password harus diisi!"
            binding.passLogin.requestFocus()
            return
        }



        ApiConfig.instanceRetrofit.login(email, pass)
            .enqueue(object : Callback<ResponseUser> {
                override fun onResponse(
                    call: Call<ResponseUser>,
                    response: Response<ResponseUser>
                ) {

                    val respon = response.body()

                    if (respon != null) {
                        if (respon.status == 0) {
                            Toast.makeText(
                                this@LoginActivity,
                                respon.pesan,
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {

                            sPH.setStatusLogin(true)
                            sPH.setUser(respon.data!!)
                            val i = Intent(this@LoginActivity,HomeActivity::class.java)
                            Toast.makeText(
                                this@LoginActivity,
                                "Selamat Datang, $email",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(i)
                            finish()
                        }
                    }


                }

                override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            })

    }

}