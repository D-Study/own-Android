package com.ownself.com.ownself.data_module

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by mac on 2017. 12. 11..
 */
open class FirstMeet: RealmObject() {

    @PrimaryKey
    open var id: Int = 0

    open var name: String? = null
    open var email: String? = null
}