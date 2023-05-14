package com.example.information

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.information.databinding.ActivityMainBinding
import java.sql.BatchUpdateException

class MainActivity : AppCompatActivity() {
    private lateinit var firstBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        firstBinding.information1Layout.setOnClickListener {
            replaceFragment(information2())
            firstBinding.information1Logo.visibility = View.INVISIBLE
            firstBinding.information1Text.visibility = View.INVISIBLE
            firstBinding.information1Text2.visibility = View.INVISIBLE
            firstBinding.information1Text3.visibility = View.INVISIBLE
        }
    }
    private fun replaceFragment(fragment : Fragment) {
        val fragment = information2()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}