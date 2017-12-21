package com.ownself.com.ownself.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.ScaleAnimation
import com.ifttt.sparklemotion.Decor
import com.ifttt.sparklemotion.Page
import com.ifttt.sparklemotion.SparkleMotion
import com.ifttt.sparklemotion.SparkleViewPagerLayout
import com.ifttt.sparklemotion.animations.RotationAnimation
import com.ownself.com.ownself.R
import kotlinx.android.synthetic.main.activity_login_view.*
import kotlinx.android.synthetic.main.layout_getstart.*
import kotlinx.android.synthetic.main.activity_login2.*
import com.ifttt.sparklemotion.Page.allPages
import android.support.v4.view.ViewCompat.animate
import com.ifttt.sparklemotion.Page.allPages
import com.ifttt.sparklemotion.animations.TranslationAnimation
import android.support.v4.view.ViewCompat.animate
import android.view.ViewGroup
import com.ownself.com.ownself.adpater.ViewPagerAdapter
import com.ifttt.sparklemotion.Page.allPages
import com.ifttt.sparklemotion.animations.ParallaxAnimation
import android.support.v4.view.ViewCompat.animate
import kotlinx.android.synthetic.main.activity_login2.view.*
import org.jetbrains.anko.toast
import com.ifttt.sparklemotion.Page.allPages
import android.support.v4.view.ViewCompat.animate
import com.ifttt.sparklemotion.animations.AlphaAnimation


/**
 * Created by mac on 2017. 12. 21..
 */
class UserLoginActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        val sparkMotion : SparkleMotion = SparkleMotion.with(sparkle_view)

        buildDecorForPage0(sparkle_view, sparkMotion)
        buildDecorForPage1(sparkle_view, sparkMotion)

        //var page01 : Page = Page.singlePage(0)
        var page : Page = Page.allPages()
        var motionTranslateY : Float = resources.getDimension(R.dimen.motion_translation_y)
        sparkMotion.animate(RotationAnimation(page, 0f, -90f)).on(R.id.start_text01, R.id.start_text02, R.id.start_text03)
        sparkMotion.animate(
                TranslationAnimation(page, 0f, 0f, 0f, motionTranslateY, false)).on(R.id.start_text01, R.id.start_text02, R.id.start_text03)


        sparkMotion.animate(ParallaxAnimation(page, -4.0f)).on(R.id.register)
        sparkMotion.animate(ParallaxAnimation(page, -3.0f)).on(R.id.login_text01)
        sparkMotion.animate(ParallaxAnimation(page, -2.5f)).on(R.id.input_name)
        sparkMotion.animate(ParallaxAnimation(page, -2.0f)).on(R.id.input_email)
        sparkMotion.animate(ParallaxAnimation(page, -1.5f)).on(R.id.input_password)
        sparkMotion.animate(ParallaxAnimation(page, -1.0f)).on(R.id.input_confirm_password)
        sparkMotion.animate(ParallaxAnimation(page, -0.5f)).on(R.id.btn_login)


        sparkle_view.getViewPager().setAdapter(PagerAdapter())


    }

    private class PagerAdapter internal constructor() : ViewPagerAdapter() {

        override fun getView(position: Int, container: ViewGroup): View? {
            when(position){

                0 -> return buildFirstPage(container)

                1 -> return buildSecondPage(container)
            }
            return View(container.getContext())

        }

        override fun getCount(): Int {
            return 2
        }

        private fun buildSecondPage(container: ViewGroup): View? {
            val rootView : View = LayoutInflater.from(container.context).inflate(R.layout.activity_login2, container, false)
            val context : Context = container.context

            rootView.btn_login.setOnClickListener{
                var name : String = rootView.input_name.text.toString()
                var email : String = rootView.input_email.text.toString()
                var password : String = rootView.input_password.text.toString()
                var confirm_pwd : String = rootView.input_confirm_password.text.toString()

                context.toast("이름: " + name + "\n" + "이메일: " + email
                        + "\n" + "비밀번호: " + password)

            }

            return rootView

        }


        private fun buildFirstPage(container: ViewGroup): View? {
            return LayoutInflater.from(container.context).inflate(R.layout.layout_getstart, container, false)

        }


    }



        private fun buildDecorForPage0(parent: SparkleViewPagerLayout, sparkMotion: SparkleMotion) {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_start, parent, false)
        val decor : Decor = Decor.Builder(view).setPage(Page.pageRange(0, 4)).behindViewPage().withLayer().build()

            var motionTranslateY : Float = resources.getDimension(R.dimen.motion_translation_y)
            sparkMotion.animate(RotationAnimation(Page.singlePage(0), 0f, -90f)).on(decor)
            sparkMotion.animate(
                    TranslationAnimation(Page.singlePage(0), 0f, 0f, 0f, motionTranslateY, false)).on(decor)
            sparkMotion.animate(AlphaAnimation(Page.singlePage(0), 1f, 0f)).on(decor)

    }


    private fun buildDecorForPage1(parent: SparkleViewPagerLayout, sparkMotion: SparkleMotion) {

    }

    companion object {

        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, UserLoginActivity::class.java)

            return intent
        }
    }

}