package com.ownself.com.ownself.anko_component

import android.view.View
import com.ownself.com.ownself.fragment.ReminderFragment_demo
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by mac on 2017. 12. 10..
 */
class Layout_reminder<Fragment> : AnkoComponent<Fragment>{

    override fun createView(ui: AnkoContext<Fragment>) = with(ui){
        verticalLayout {

            textView("회고록").textSize = 100f

        }
    }
}