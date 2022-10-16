package com.a706012110039.levelup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.a706012110039.levelup.databinding.ActivityBottomnavbarActiityBinding

class BottomnavbarActiity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomnavbarActiityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomnavbarActiityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setcurfragment(HomeFragment())

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

    private fun setcurfragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().apply {
            replace(binding.framelayoutBottomnavbar.id, fragment)
            commit()
        }
    }

}