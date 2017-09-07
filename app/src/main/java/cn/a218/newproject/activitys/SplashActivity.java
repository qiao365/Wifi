package cn.a218.newproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.ViewPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class SplashActivity extends AutoLayoutActivity {
    private ViewPager mViewPager;
    private ArrayList<View> mList;
    private Button mButton;
    private ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide_view);
        urls.add("http://192.168.9.1:7878/yy/1.jpg");
        urls.add("http://192.168.9.1:7878/yy/2.jpg");
        urls.add("http://192.168.9.1:7878/yy/3.jpg");
        urls.add("http://192.168.9.1:7878/yy/4.jpg");
        mList = new ArrayList<>();
        for (String url : urls) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout3, null);
            mList.add(view);
        }
        init();
        setDate();
    }
//[
//    {
//        alt:'图1',
//                src:'http://www.sina.com.cn/abc.jpg',
//            order:1
//    },
//            ]
    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(mList, urls);
        mViewPager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mViewPager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());
    }

    private void setDate() {
        for (int i = 0; i < mList.size(); i++) {
            ImageView mImageView = (ImageView) mList.get(i).findViewById(R.id.mImageView);
            Button mButton = (Button) mList.get(i).findViewById(R.id.button_enter);
            if (i + 1 == mList.size()) {
                mButton.setVisibility(View.VISIBLE);
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
            }
            Picasso.with(SplashActivity.this)
                    .load(urls.get(i))
                    .error(R.mipmap.ic_error)
                    .fit()
                    .centerCrop()
                    .into(mImageView);
        }
    }

}
