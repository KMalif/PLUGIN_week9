package com.example.week9.realm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class myapp:Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
    }
}