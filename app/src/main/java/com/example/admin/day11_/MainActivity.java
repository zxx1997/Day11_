package com.example.admin.day11_;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    private String[] titles={"首页","新闻","纪录","日志"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerSlidingTabStrip pst= (PagerSlidingTabStrip) findViewById(R.id.pst);
        ViewPager vp= (ViewPager) findViewById(R.id.vp);
       // ViewPager vp1= (ViewPager) findViewById(R.id.vp1);
        /*vp1.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        });*/
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        pst.setViewPager(vp);
    }
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                    fragment=new Fragment01();
                    break;
                case 1:
                    fragment=new Fragment02();
                    break;
                case 2:
                    fragment=new Fragment03();
                    break;
                case 3:
                    fragment=new Fragment04();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }
}
