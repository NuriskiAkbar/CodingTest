package com.rhiquest.mohnuriskiakbar_codingtestapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fragment = FragmentB().apply {
            arguments = intent.extras // Pass the bundle to the fragment
        }

        setFragment(fragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameContainer2, fragment)
        fragmentTransaction.commit()
    }
}