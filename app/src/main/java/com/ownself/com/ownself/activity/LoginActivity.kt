package com.ownself.com.ownself.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ownself.com.ownself.R
import com.ownself.com.ownself.constants.ResultCodes
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast


/**
 * Created by mac on 2017. 12. 10..
 */
class LoginActivity : BaseActivity() {

    var email : String = ""
    var password : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val loginButton = btn_signin
        loginButton.setOnClickListener { view -> getData()}

    }

    private fun getData() {
        email = edit_txt_email.text.toString()
        password = edit_pwd_email.text.toString()

        toast(email + password)

        //이부분 이상.ㅠㅠ DB를 아직 안만들어서 로그인 판단해보려했으나 자바와 다르다...
        val main : MainActivity = MainActivity()
        main.user_login = 1

        setResult(ResultCodes.SUCCESS)
        finish()
    }

    companion object {

        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, LoginActivity::class.java)

            return intent
        }
    }

}