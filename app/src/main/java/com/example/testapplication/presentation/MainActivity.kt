package com.example.testapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.testapplication.data.storage.models.User


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: MainViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity created _______________________________")


        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        vm.resultLiveData.observe(this, Observer {
            binding.tvUsername.text = it
        })

        binding.btnSetUsername.setOnClickListener {
            // СОХРАНИТЬ
            val name = binding.etSetUsername.text.toString()
            val lastName = binding.etSetUserLastName.text.toString()
            vm.save(name, lastName)
        }

        binding.btnGetData.setOnClickListener {
            // ПОЛУЧИТЬ

            vm.load()
        }
         
    }
}
