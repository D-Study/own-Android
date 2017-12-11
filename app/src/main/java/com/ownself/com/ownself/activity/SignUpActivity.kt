package com.ownself.com.ownself.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ownself.com.ownself.R

/**
 * Created by mac on 2017. 12. 11..
 */
class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

    }



    companion object {

        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, SignUpActivity::class.java)

            return intent
        }
    }
}