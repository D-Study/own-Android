package com.ownself.com.ownself.data_module

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by mac on 2017. 12. 11..
 */
open class FirstMeet (first : Int, id : Int) : RealmObject() {

    @PrimaryKey
    var id : Int = 0

    var first : Int = 0

}