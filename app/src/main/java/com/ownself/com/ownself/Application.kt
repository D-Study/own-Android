package com.ownself.com.ownself

import android.app.Application
import com.ownself.com.ownself.data_module.FirstMeet
import com.vicpin.krealmextensions.RealmConfigStore
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by mac on 2017. 12. 14..
 */

class Application : Application() {

    private lateinit var realm: Realm

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val firstmeetConfig = RealmConfiguration.Builder().name("user-db").schemaVersion(1).deleteRealmIfMigrationNeeded().build()
        // delete all data
        Realm.deleteRealm(Realm.getDefaultConfiguration())
        Realm.deleteRealm(firstmeetConfig)

        RealmConfigStore.init(FirstMeet::class.java, firstmeetConfig)
    }
}