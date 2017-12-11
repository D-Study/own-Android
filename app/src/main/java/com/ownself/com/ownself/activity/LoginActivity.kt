package com.ownself.com.ownself.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ownself.com.ownself.R
import com.ownself.com.ownself.constants.RequestCodes
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


        val btn_signIn = btn_signin
        btn_signIn.setOnClickListener { v -> getData()}

        val btn_signUp = btn_signup
        btn_signUp.setOnClickListener { v -> startActivityForResult(
                SignUpActivity.newIntent(this), RequestCodes.SIGN_UP) }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        requestCodes(requestCode, resultCode)
    }

    private fun requestCodes(requestCode: Int, resultCode: Int) {
        when(requestCode){
            RequestCodes.SIGN_UP ->
                when(resultCode){
                    ResultCodes.SUCCESS -> toast("회원가입 완료") // setResult(resultCode) / finish()

                }
        }
    }

    companion object {

        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, LoginActivity::class.java)

            return intent
        }
    }

}