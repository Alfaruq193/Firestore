package com.varoo.firestore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.varoo.firestore.databinding.ActivityHomeBinding
import com.varoo.firestore.helper.SharedPreference
import com.varoo.firestore.home.HomeFragment
import com.varoo.firestore.user.UserFragment
import com.varoo.firestore.wishlist.WishlistFragment

class HomeActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentUser: Fragment = UserFragment()
    val fragmentWishlist: Fragment = WishlistFragment()
    var active: Fragment = fragmentHome
    private lateinit var sPH: SharedPreference

    private lateinit var binding: ActivityHomeBinding
    val fm: FragmentManager = supportFragmentManager

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sPH = SharedPreference(this)
        buttonNavigation()
//        setupTabs()
    }



    private fun buttonNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentUser).hide(fragmentUser).commit()
        fm.beginTransaction().add(R.id.container, fragmentWishlist).hide(fragmentWishlist)
            .commit()



        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_wishlist -> {
                    callFragment(1, fragmentWishlist)
                }
                R.id.navigation_user -> {
//                    callFragment(2, fragmentPengaturan)
                    if (sPH.getStatusLogin(false)) {
                        callFragment(2, fragmentUser)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
            false
        }
    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

//    private fun setupTabs() {
//        val adapter = ViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(HomeFragment(), "Home")
//        adapter.addFragment(PembayaranFragment(), "Pembayaran")
//        adapter.addFragment(PesananFragment(), "Pesanan")
//        adapter.addFragment(PengaturanFragment(), "Pengaturan")
//
//        binding.viewPager.adapter = adapter
//        binding.tabs.setupWithViewPager(binding.viewPager)
//
//        binding.tabs. getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
//        binding.tabs. getTabAt(1)!!.setIcon(R.drawable.ic_baseline_attach_money_24)
//        binding.tabs. getTabAt(2)!!.setIcon(R.drawable.ic_baseline_article_24)
//        binding.tabs. getTabAt(3)!!.setIcon(R.drawable.ic_baseline_settings_24)
//    }
}