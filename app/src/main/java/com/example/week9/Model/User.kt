package com.example.week9.Model

import io.realm.RealmObject
import io.realm.annotations.RealmClass
import java.io.StringWriter

@RealmClass
open class User: RealmObject() {
    private var id : Int? = null
    private var nama : String? = null
    private var email : String? = null


    fun setId(id:Int){
        this.id = id
    }
    fun getId():Int?{
        return id
    }
    fun setNama(nama : String){
        this.nama = nama
    }
    fun getNama():String?{
        return nama
    }
    fun setEmail(email : String){
        this.email = email
    }
    fun getEmail():String?{
        return email
    }
}