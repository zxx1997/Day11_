package com.example.admin.day11_;

import android.content.Intent;
import android.preference.PreferenceScreen;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<View> views;
    //private int id;
    private boolean bl;
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        views=new ArrayList<>();
        LayoutInflater inflater=LayoutInflater.from(this);
        View v1=inflater.inflate(R.layout.vp_item1,null);
        View v2=inflater.inflate(R.layout.vp_item2,null);
        View v3=inflater.inflate(R.layout.vp_item3,null);
        views.add(v1);
        views.add(v2);
        views.add(v3);
        vp= (ViewPager) findViewById(R.id.vp2);

        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //id=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        bl=false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        bl=true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if(vp.getCurrentItem()==vp.getAdapter().getCount()-1&&!bl){
                            Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        bl=true;
                        break;
                }
            }
        });
        /*vp.setOnTouchListener(new View.OnTouchListener() {
            float startx;
            float endx;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case  MotionEvent.ACTION_DOWN:
                        startx=event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endx=event.getX();

                        if(id==2&&startx-endx>=10){
                            Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
                return false;
            }
        });*/

    }
}
