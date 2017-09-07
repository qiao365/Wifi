package cn.a218.newproject.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.GridAdapter;
import cn.a218.newproject.models.VideoMsg;
import cn.a218.newproject.views.MyGridView;
import cn.a218.newproject.views.ObservableScrollView;

public class MasterDancesActivity extends AutoLayoutActivity implements View.OnClickListener,ObservableScrollView.ScrollViewListener {

    private View layoutHead;
    private ObservableScrollView scrollView;
    private ImageView imageView;
    private int height ;
    private ImageView nodataImageView;
    private MyGridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_dances);
        initView();
    }


    private void initView() {
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("广场舞课堂");

        scrollView = (ObservableScrollView) findViewById(R.id.scrollview);
        layoutHead = findViewById(R.id.view_head);
        imageView = (ImageView) findViewById(R.id.imageView1);
        layoutHead.setBackgroundColor(Color.argb(0, 255, 255, 255));
        //获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height =   imageView.getHeight();
                imageView.getWidth();
                scrollView.setScrollViewListener(MasterDancesActivity.this);
            }
        });

        mGridView = (MyGridView) findViewById(R.id.mGridView);
        nodataImageView = (ImageView) findViewById(R.id.nodataImageView);
        List<VideoMsg> mGalleryPhoneData = new ArrayList<VideoMsg>();
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        GridAdapter ad = new GridAdapter(this, mGalleryPhoneData);
        mGridView.setAdapter(ad);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MasterDancesActivity.this, VideoPlayActivity.class));
            }
        });
        scrollView.smoothScrollTo(0, 0);
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y,
                                int oldx, int oldy) {

//		Log.i("TAG","y--->"+y+"    height-->"+height);
        if(y<=height){
            float scale =(float) y /height;
            float alpha =  (255 * scale);
//			Log.i("TAG","alpha--->"+alpha);

            //layout全部透明
//			layoutHead.setAlpha(scale);

            //只是layout背景透明(仿知乎滑动效果)
            layoutHead.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.myuploadTextView:
                nodataImageView.setVisibility(View.GONE);
                mGridView.setVisibility(View.VISIBLE);
                scrollView.smoothScrollTo(0, 0);
                break;
            case R.id.mylikeTextView:
                nodataImageView.setVisibility(View.VISIBLE);
                mGridView.setVisibility(View.GONE);
                break;
        }
    }
}
