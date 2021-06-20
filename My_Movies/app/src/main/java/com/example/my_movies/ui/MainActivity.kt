package com.example.my_movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.my_movies.R
import com.example.my_movies.adapters.ViewPagerAdapter
import com.example.my_movies.databinding.ActivityMainBinding
import com.example.my_movies.viewmodels.ActivityViewModel
import com.example.my_movies.viewmodels.PopularViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {



   // private lateinit var Binding:ActivityMainBinding
  //  private lateinit var activityviewmodel:ActivityViewModel
    private lateinit var viewpager:ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var ads: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager=findViewById(R.id.view_pager_2)
        tabLayout=findViewById(R.id.tab_layout)
        ads=findViewById(R.id.adView1)

      // Binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
     //  activityviewmodel=ViewModelProvider(this).get(ActivityViewModel::class.java)
     //  Binding.activityviewmodel=activityviewmodel
      // Binding.lifecycleOwner
      //   Binding.root

        // Google Admob
        MobileAds.initialize(this){
            val adbuilder:AdRequest= AdRequest.Builder().build()
            ads.loadAd(adbuilder)
        }

        // View Pager2 & adapter
        val view_pager_adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter=view_pager_adapter
        TabLayoutMediator(tabLayout,viewpager){
                tab,position ->
            when(position)
            {
                0 -> tab.text="POPULAR"
                1 -> tab.text="TOP RATED"
                2-> tab.text="NOW PLAYING"
            }
        }.attach()


        viewpager
            .registerOnPageChangeCallback( object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })







    }
}


