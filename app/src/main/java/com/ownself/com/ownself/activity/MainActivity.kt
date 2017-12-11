package com.ownself.com.ownself.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.ownself.com.ownself.R
import com.ownself.com.ownself.anko_component.Layout_mainactivity
import com.ownself.com.ownself.constants.RequestCodes
import com.ownself.com.ownself.constants.ResultCodes
import com.ownself.com.ownself.data_module.FirstMeet
import com.ownself.com.ownself.fragment.ReminderFragment_demo
import io.realm.Realm
import io.realm.RealmResults
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : BaseActivity() {

    //회원 판단 기준
    var user_login : Int? = 0

    val realm : Realm = Realm.getDefaultInstance()

    var firstmeet : FirstMeet? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Layout_mainactivity().setContentView(this)

        val fragment : ReminderFragment_demo = ReminderFragment_demo()
        replaceContentFragment(R.id.content_frame, fragment)

        createFirstMeet()

        firstmeet = realm.where(FirstMeet::class.java)
                .equalTo("id", 1).findFirst()

        user_login = firstmeet?.first

        check_FirstMeet(user_login)

    }




    private fun createFirstMeet() {
        realm.beginTransaction()

        var f = firstmeet?: realm.createObject(FirstMeet::class.java)

        f.id = 1
        f.first = 1

        realm.commitTransaction()
    }

    fun Activity.replaceContentFragment(@IdRes frameId: Int, fragment: android.app.Fragment){
        fragmentManager.beginTransaction().replace(frameId, fragment).commit()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        requestCodes(requestCode, resultCode)

    }

    fun check_FirstMeet(login : Int?) {
        when (login) {
            0 -> startActivityForResult(LoginActivity.newIntent(this), RequestCodes.SIGN_IN)
            1 -> user_login?.let { toast(it) }
        }

    }

    fun requestCodes(requestCode: Int, resultCode: Int) {
        when(requestCode){
            RequestCodes.SIGN_IN -> resultCodes(resultCode)

        }

    }

    fun resultCodes(resultCode : Int) {
        when(resultCode){
            ResultCodes.SUCCESS -> toast("로그인 성공")
        }
    }


}
