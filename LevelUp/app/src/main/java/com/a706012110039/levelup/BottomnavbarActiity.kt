package com.a706012110039.levelup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.a706012110039.levelup.databinding.ActivityBottomnavbarActiityBinding
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView

class BottomnavbarActiity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomnavbarActiityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomnavbarActiityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setcurfragment(HomeFragment())


        if(!tourguidebottomfinished()) {
            tourguide1()
        }

        binding.bottomNavigationViewBottomnavbar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu1_menu -> setcurfragment(HomeFragment())
                R.id.menu2_menu -> setcurfragment(MyprojectsFragment())
                R.id.menu3_menu -> setcurfragment(FindprojectsFragment())
                R.id.menu4_menu -> setcurfragment(ProfileFragment())
            }
            true
        }
    }
    private fun tourguidebottomfinished(): Boolean{
        val sharedPref = this.getSharedPreferences("tourguideproject", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
    private fun setcurfragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().apply {
            replace(binding.framelayoutBottomnavbar.id, fragment)
            commit()
        }
    }

    fun tourguide1(){
        setcurfragment(HomeFragment())
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.menu1_menu),"Home Page","This page will contain infos that are important such as Upcoming tasks") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide11()
                }
            })
    }

    fun tourguide11(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.recentproject),"","This part contains projects that you have taken") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(50),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide12()
                }
            })
    }

    fun tourguide12(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.carouselnews),"Advertisements","This part contains advertisements") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(80),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide13()
                }
            })
    }

    fun tourguide13(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.textView10),"News","This part contains information about viral news that will benefit you") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide2()
                }
            })
    }

    fun tourguide2(){
        setcurfragment(MyprojectsFragment())
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.menu2_menu), "My Projects Page", "This page will contain projects that you are taking or have taken in the past") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide21()
                }
            })
    }

    fun tourguide21(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.searchView_myProjects), "", "Use this for faster navigation") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide22()
                }
            })
    }

    fun tourguide22(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.cv_ongoing), "", "Press this to navigate to current projects") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide23()
                }
            })
    }

    fun tourguide23(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.cv_past), "", "Press this to navigate to current projects") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }
                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide3()
                }
            })
    }

    fun tourguide3(){
        setcurfragment(FindprojectsFragment())
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.menu3_menu), "Search Projects page", "You can search projects to partake in or you can create projects for other people to collab with you") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide31()
                }
            })
    }

    fun tourguide31(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.searchView_jobsForYou), "", "You can use this to search for projects you desire") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide32()
                }
            })
    }

    fun tourguide32(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.rvtour), "", "You can press this to find out more about the project you are interested in") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(40),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide33()
                }
            })
    }

    fun tourguide33(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.addDataFAB), "", "You can press this to create a project for other people to join you") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide4()
                }
            })
    }

    fun tourguide4(){
        setcurfragment(ProfileFragment())
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.menu4_menu), "Profile page", "This page will contain general information about you") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view?.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }

                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide41()
                }
            })
    }

    fun tourguide41(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.imageView5), "", "you can edit your profile info here") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide42()
                }
            })
    }
    fun tourguide44(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.status), "", "This part contains all of your basic information such as name email and your current user status") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(60),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide45()
                }
            })
    }

    fun tourguide42(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.imageView13), "", "This part contains all of your basic information such as name email and your current user status") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide43()
                }
            })
    }

    fun tourguide43(){
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.rv_Profession), "", "you can only join projects that matches with your profession/interest, you can change them anytime in the settings page") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(29),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    view.dismiss(true)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide44()
                }
            })
    }

    fun tourguide45(){
        val sharedPref = this.getSharedPreferences("tourguideproject", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
        TapTargetView.showFor(this,  // `this` is an Activity
            TapTarget.forView(findViewById(R.id.feedback), "", "uou can easily enter settings page or also get help using the featues in this tab") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(android.R.color.holo_purple)
                .drawShadow(true)
                .transparentTarget(true)
                .targetRadius(60),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    view?.dismiss(true)
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    setcurfragment(HomeFragment())
                }
            })
    }

}