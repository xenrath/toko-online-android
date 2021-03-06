package com.xenrath.tokoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xenrath.tokoonline.activity.LoginActivity
import com.xenrath.tokoonline.fragment.AkunFragment
import com.xenrath.tokoonline.fragment.HomeFragment
import com.xenrath.tokoonline.fragment.KeranjangFragment
import com.xenrath.tokoonline.helper.SharedPref
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fragmentKeranjang: Fragment = KeranjangFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView
    
    private var statusLogin = false

    private lateinit var s : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()
    }

    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang).commit()

        menu = nav_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        nav_view.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_keranjang -> {
                    callFragment(1, fragmentKeranjang)
                }
                R.id.navigation_akun -> {
                    if (s.getStatusLogin()){
                        callFragment(2, fragmentAkun)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        Log.d("Response", "Akun")
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}