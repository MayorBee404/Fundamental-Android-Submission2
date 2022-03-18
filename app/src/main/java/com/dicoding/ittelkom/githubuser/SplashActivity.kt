@file:Suppress("DEPRECATION")

package com.dicoding.ittelkom.githubuser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dicoding.ittelkom.githubuser.ui.listuser.ListUser

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity,ListUser::class.java)
            startActivity(intent)
            finish()

        },3000)

    }
}

