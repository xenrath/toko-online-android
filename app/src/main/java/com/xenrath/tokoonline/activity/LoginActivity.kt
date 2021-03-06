package com.xenrath.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xenrath.tokoonline.R
import com.xenrath.tokoonline.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btn_masuk.setOnClickListener{
            s.setStatusLogin(true)
        }
    }
}