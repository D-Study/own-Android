package com.ownself.com.ownself.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ownself.com.ownself.R
import com.ownself.com.ownself.anko_component.Layout_reminder
import kotlinx.android.synthetic.main.fragment_reminder.view.*
import org.jetbrains.anko.AnkoContext
import java.util.zip.Inflater

/**
 * Created by mac on 2017. 12. 10..
 */

class ReminderFragment_demo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //val rootView = Layout_reminder<Fragment>().createView(AnkoContext.Companion.create(activity,this))

        val rootView = inflater.inflate(R.layout.fragment_reminder, container, false)

        rootView.text_test.text = "회고록"

        return rootView

    }
}