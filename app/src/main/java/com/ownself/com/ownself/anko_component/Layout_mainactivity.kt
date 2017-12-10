package com.ownself.com.ownself.anko_component

import android.view.View
import android.widget.LinearLayout
import com.ownself.com.ownself.R
import com.ownself.com.ownself.activity.MainActivity
import org.jetbrains.anko.*

/**
 * Created by mac on 2017. 12. 10..
 */

class Layout_mainactivity : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        return linearLayout {
            lparams(width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL

            val content_frame = frameLayout {
                id = R.id.content_frame

            }.lparams(width = matchParent, height = matchParent)

        }
    }

}