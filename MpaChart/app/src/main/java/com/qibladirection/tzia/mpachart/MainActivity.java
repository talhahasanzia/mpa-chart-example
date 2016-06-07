package com.qibladirection.tzia.mpachart;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setTitle("Charts");

        //barChart.invalidate();
    }
    class MyPagerAdapter extends FragmentStatePagerAdapter
    {

        public MyPagerAdapter(FragmentManager fragmentManager)
        {

            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0)
                return new BarChartFragment();
            else
                return new PieChartFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0)
                return "Bar Chart";
            else
                return "Pie Chart";
        }
    }
}
