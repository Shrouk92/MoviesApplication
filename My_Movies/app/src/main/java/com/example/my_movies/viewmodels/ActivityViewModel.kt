package com.example.my_movies.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.example.my_movies.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ActivityViewModel: ViewModel() {


  /*  fun ViewPager_Adapter( )
    {
        // View Pager2 & adapter
        val view_pager_adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter=view_pager_adapter
        TabLayoutMediator(Binding.tabLayout,Binding.viewPager2){
                tab,position ->
            when(position)
            {
                0 -> tab.text="POPULAR"
                1 -> tab.text="TOP RATED"
                2-> tab.text="NOW PLAYING"
            }
        }.attach()


        viewpager.registerOnPageChangeCallback( object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Binding.tabLayout.selectTab(Binding.tabLayout.getTabAt(position))
            }
        })
    }

*/

}