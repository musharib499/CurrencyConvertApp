package com.demo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.demo.R
import com.demo.databinding.ActivitySplashBinding
import com.demo.ui.viewModule.SplashViewModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private var binding:ActivitySplashBinding?= null
    private val viewMode:SplashViewModule by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        binding?.apply {
            lifecycleOwner = this@SplashActivity
            vm = viewMode
        }
        viewMode.loadData(this)
        viewMode.moveNext.observe(this,{
            if (it == true){
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        })
        viewMode.loading.observe(this, {
            it.msg?.let {Toast.makeText(this, it, Toast.LENGTH_SHORT).show()}
        })

    }
}