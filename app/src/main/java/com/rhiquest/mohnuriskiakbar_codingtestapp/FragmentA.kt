package com.rhiquest.mohnuriskiakbar_codingtestapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.FragmentABinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItem
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItemItem
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.ApiService
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.Interface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvListitem.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvListitem.setHasFixedSize(true)
        getItemList{ items: List<ResponseGetAllItemItem> ->
            val adapter = ItemsAdapter(items)
            binding.rvListitem.adapter = adapter
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getItemList(function: (List<ResponseGetAllItemItem>) -> Unit) {
        val apiService = ApiService.getInstance().create(Interface::class.java)
            apiService.getAllItem().enqueue(object : Callback<ResponseGetAllItemItem>{
                override fun onResponse(
                    call: Call<ResponseGetAllItemItem>,
                    response: Response<ResponseGetAllItemItem>
                ) {
                    val data = response.body()
                    return function( data as List<ResponseGetAllItemItem>)
                }

                override fun onFailure(call: Call<ResponseGetAllItemItem>, t: Throwable) {
                    Log.d("error fetch","ini errornya : $t")
                }

            })
    }
}