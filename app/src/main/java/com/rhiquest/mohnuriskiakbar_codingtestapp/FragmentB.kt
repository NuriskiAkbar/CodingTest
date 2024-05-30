package com.rhiquest.mohnuriskiakbar_codingtestapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.FragmentABinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.FragmentBBinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.ApiService
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.Interface


class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id =
        val apiService = ApiService.getInstance().create(Interface::class.java)
        apiService.getItemDetail()
    }
}