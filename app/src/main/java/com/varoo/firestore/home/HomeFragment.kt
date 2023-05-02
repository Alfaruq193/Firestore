package com.varoo.firestore.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.varoo.firestore.ChangePasswordActivity
import com.varoo.firestore.R
import com.varoo.firestore.adapter.AdapterSllider
import com.varoo.firestore.databinding.HomeFragmentBinding
import com.varoo.firestore.rental.RentalActivity


class HomeFragment : Fragment() {

    private var _binding : HomeFragmentBinding?= null
    lateinit var vpSlider: ViewPager
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val view: View = inflater.inflate(R.layout.home_fragment, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.carousel)
        arrSlider.add(R.drawable.carousel1)
        arrSlider.add(R.drawable.carousel2)

        val adapterSLider = AdapterSllider(arrSlider, activity)
        vpSlider.adapter = adapterSLider

        val pesawat = view.findViewById<LinearLayout>(R.id.tv_pesawat)
        pesawat.setOnClickListener {
            val i = Intent(context, PesawatActivity::class.java)
            startActivity(i)
        }

        val kapal = view.findViewById<LinearLayout>(R.id.tv_kapal)
       kapal.setOnClickListener {
            val i = Intent(context, KapalActivity::class.java)
            startActivity(i)
        }
        val kereta = view.findViewById<LinearLayout>(R.id.tv_kereta)
        kereta.setOnClickListener {
            val i = Intent(context, KeretaActivity::class.java)
            startActivity(i)
        }
        val rental = view.findViewById<LinearLayout>(R.id.tv_rental)
        rental.setOnClickListener {
            val i = Intent(context, RentalActivity::class.java)
            startActivity(i)
        }

        val resto = view.findViewById<LinearLayout>(R.id.tv_restaurant)
        resto.setOnClickListener {
            val i = Intent(context, RestoActivity::class.java)
            startActivity(i)
        }


        val map = view.findViewById<LinearLayout>(R.id.tv_map)
        map.setOnClickListener {
            val intentPLaystore = Intent(Intent.ACTION_VIEW)
            intentPLaystore.data= Uri.parse("https://www.google.com/maps/@-6.8678439,107.605137,9z?hl=ID")
            startActivity(intentPLaystore)
        }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}