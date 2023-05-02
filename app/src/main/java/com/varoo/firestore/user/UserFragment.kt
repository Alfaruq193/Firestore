package com.varoo.firestore.user

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.varoo.firestore.ChangePasswordActivity
import com.varoo.firestore.LoginActivity
import com.varoo.firestore.R
import com.varoo.firestore.helper.SharedPreference
import com.varoo.firestore.profile.UbahProfileActivity

class UserFragment : Fragment() {

    lateinit var sPH: SharedPreference
//    lateinit var telpUser: TextView
    lateinit var namaUser: TextView
    lateinit var emailUser: TextView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.user_fragment, container,false)

        init(view)

        sPH = SharedPreference(requireActivity())

        val ubahProfile = view.findViewById<RelativeLayout>(R.id.btn_editProfile)
        ubahProfile.setOnClickListener {
            val i = Intent(context,UbahProfileActivity::class.java)
            startActivity(i)
        }

        val ubahPassword = view.findViewById<RelativeLayout>(R.id.btn_ubahPassword)
        ubahPassword.setOnClickListener {
            val i = Intent(context,ChangePasswordActivity::class.java)
            startActivity(i)
        }
        val alamat = view.findViewById<RelativeLayout>(R.id.btn_settingAlamat)
        alamat.setOnClickListener {
            val intentPLaystore = Intent(Intent.ACTION_VIEW)
            intentPLaystore.data= Uri.parse("https://www.google.com/maps/@-6.8678439,107.605137,9z?hl=ID")
            startActivity(intentPLaystore)
        }


        val privasi = view.findViewById<RelativeLayout>(R.id.btn_privasi)
        privasi.setOnClickListener {
            val i = Intent(context,PrivasiActivity::class.java)
            startActivity(i)
        }

        val tentang = view.findViewById<RelativeLayout>(R.id.btn_tentang)
        tentang.setOnClickListener {
            val i = Intent(context,TentangActivity::class.java)
            startActivity(i)
        }

        val btnKeluar = view.findViewById<Button>(R.id.btn_keluar)
        btnKeluar.setOnClickListener {
            sPH.setStatusLogin(false)
            val i = Intent(context,LoginActivity::class.java)
            Toast.makeText(context, "Berhasil Logout", Toast.LENGTH_SHORT).show()
            startActivity(i)
            activity?.finish()


        }

        setUser()
        return view

    }




    private fun setUser() {
        val user = sPH.getUser()
        namaUser.text = user?.name
        emailUser.text = user?.email
    }

    private fun init(view: View) {
//        telpUser = view.findViewById<TextView>(R.id.tv_telp)
        namaUser = view.findViewById<TextView>(R.id.tv_nama)
        emailUser = view.findViewById<TextView>(R.id.tv_email)

    }
}