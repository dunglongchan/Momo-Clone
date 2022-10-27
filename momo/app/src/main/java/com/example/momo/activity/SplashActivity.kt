package com.example.momo.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.momo.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
//            if (MyApplication.getFirstOpen(this@SplashActivity)){
//                startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
//            }else{
//                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//            }
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
            finish()
        }, 2000)
    }
}