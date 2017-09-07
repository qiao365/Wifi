package cn.a218.newproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 15/7/27.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> mList;
    private ArrayList<String> mUrls = new ArrayList<>();
    public ViewPagerAdapter(ArrayList list,ArrayList<String> mUrls){
        mList = list;
        mUrls = mUrls;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(mList.get(position));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("wing","viewAdatper here");
        ((ViewPager)container).addView(mList.get(position));
        return mList.get(position);
    }
}
