package com.example.week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week9.Adapter.MainAdapter
import com.example.week9.Model.User
import com.example.week9.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.kotlin.createObject

class MainActivity : AppCompatActivity() {
    lateinit var realm : Realm
    lateinit var mainAdapter : MainAdapter
    val lm = LinearLayoutManager(this)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        getAllUser()
        addData()

    }

    fun addData(){
        binding.btnSave.setOnClickListener {
            realm.beginTransaction()
            var user = realm.createObject(User::class.java)
            user.setNama(binding.nameEditText.text.toString())
            user.setEmail(binding.emailEditText.text.toString())

            binding.tvResult.text = user.getNama()+ " "+ user.getEmail()
            realm.commitTransaction()

        }
    }

    fun setupView(){
        binding.rvUser.layoutManager = lm
        mainAdapter = MainAdapter(mutableListOf())
        binding.rvUser.adapter = mainAdapter
        Realm.init(this)
        realm = Realm.getDefaultInstance()
        getAllUser()
    }

    fun getAllUser(){
        realm.where(User::class.java).findAll().let {
            mainAdapter.setUser(it)
        }
    }


}