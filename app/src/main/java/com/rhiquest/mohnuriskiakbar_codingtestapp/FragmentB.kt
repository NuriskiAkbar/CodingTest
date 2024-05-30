package com.rhiquest.mohnuriskiakbar_codingtestapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.FragmentABinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.databinding.FragmentBBinding
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetItemDetail
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.ApiService
import com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit.Interface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        val id = arguments?.getInt("id")
        val apiService = ApiService.getInstance().create(Interface::class.java)
        if (id != null) {
            apiService.getItemDetail(id).enqueue(object : Callback<ResponseGetItemDetail>{
                override fun onResponse(
                    call: Call<ResponseGetItemDetail>,
                    response: Response<ResponseGetItemDetail>
                ) {
                    val data = response.body()

                    binding.useriddetail.text = data!!.userId.toString()
                    binding.titledetail.text = data.title
                    binding.statusdetail.text = data.completed.toString()
                }

                override fun onFailure(call: Call<ResponseGetItemDetail>, t: Throwable) {
                    Toast.makeText(context, "ini errornya : $t", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}