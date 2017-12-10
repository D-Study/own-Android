package com.ownself.com.ownself.activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.ownself.com.ownself.R
import com.ownself.com.ownself.anko_component.Layout_mainactivity
import com.ownself.com.ownself.fragment.ReminderFragment_demo
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    private var content: Fragment? = null

    private var user_login : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Layout_mainactivity().setContentView(this)


        val fragment : ReminderFragment_demo = ReminderFragment_demo()
        replaceContentFragment(R.id.content_frame, fragment)
    }


    fun Activity.replaceContentFragment(@IdRes frameId: Int, fragment: android.app.Fragment){
        fragmentManager.beginTransaction().replace(frameId, fragment).commit()
    }


}
