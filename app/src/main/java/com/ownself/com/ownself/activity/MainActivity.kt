package com.ownself.com.ownself.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.widget.Toast
import com.ownself.com.ownself.Application
import com.ownself.com.ownself.R
import com.ownself.com.ownself.anko_component.Layout_mainactivity
import com.ownself.com.ownself.constants.RequestCodes
import com.ownself.com.ownself.constants.ResultCodes
import com.ownself.com.ownself.data_module.FirstMeet
import com.ownself.com.ownself.fragment.ReminderFragment_demo
import io.realm.Realm
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

class MainActivity : BaseActivity() {

    //회원 판단 기준
    var firstId : Int? =0
    var user_login : Int? = 0

    private var realm: Realm by Delegates.notNull()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Layout_mainactivity().setContentView(this)

        val fragment : ReminderFragment_demo = ReminderFragment_demo()
        replaceContentFragment(R.id.content_frame, fragment)



        check_FirstMeet(user_login)

    }



    fun Activity.replaceContentFragment(@IdRes frameId: Int, fragment: android.app.Fragment){
        fragmentManager.beginTransaction().replace(frameId, fragment).commit()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        requestCodes(requestCode, resultCode)

    }

    fun check_FirstMeet(login : Int?) {
        when (login) {
            0 -> startActivityForResult(UserLoginActivity.newIntent(this), RequestCodes.SIGN_IN)
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
