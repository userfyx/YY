package com.yy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * autour: 范永兴
 * date: 2016/11/27 20:22
 * update: 2016/11/27
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private List<View> viewsList=new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        initView();
        //适配器
        viewpager.setAdapter(new MyAdapter(MainActivity.this,viewsList));

    }
    //集合，，背景图片
    private void initView() {
        viewsList=new ArrayList<View>();

        View view1=View.inflate(MainActivity.this,R.layout.splash,null);
        view1.setBackgroundResource(R.mipmap.splash_fg_01);

        View view2=View.inflate(MainActivity.this,R.layout.splash,null);
        view2.setBackgroundResource(R.mipmap.splash_fg_02);

        View view3=View.inflate(MainActivity.this,R.layout.splash,null);
        view3.setBackgroundResource(R.mipmap.splash_fg_03);

        View view4=View.inflate(MainActivity.this,R.layout.splash,null);
        view4.setBackgroundResource(R.mipmap.splash_fg_04);
    }

    //MyAdapter
     class MyAdapter extends PagerAdapter {

        private Context context;
        private final List<View> list;

        public MyAdapter(Context context,List<View> list) {
            this.context = context;
            this.list = list;
        }

         @Override
         public int getCount() {
             return list.size();
         }

         @Override
         public boolean isViewFromObject(View view, Object object) {
             return view==object;
         }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = list.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }
}
