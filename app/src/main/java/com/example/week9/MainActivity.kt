package com.example.week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week9.Model.User
import com.example.week9.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.kotlin.createObject

class MainActivity : AppCompatActivity() {
    lateinit var realm : Realm
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRealm()
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
    fun setRealm(){
        realm = Realm.getDefaultInstance()
    }
}