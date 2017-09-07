package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.GridAdapter;
import cn.a218.newproject.models.VideoMsg;

public class HotActivity extends AutoLayoutActivity implements View.OnClickListener,PullToRefreshBase.OnRefreshListener2<GridView> {

    private PullToRefreshGridView mPullToRefreshGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        ImageView iv_menu = (ImageView) findViewById(R.id.iv_menu);
        tv_info.setText("热门舞曲");
        iv_menu.setImageResource(R.mipmap.ic_top_search);
        iv_menu.setVisibility(View.VISIBLE);
        mPullToRefreshGridView = (PullToRefreshGridView) findViewById(R.id.mGridViewJingXuan);
        // 刷新label的设置
        mPullToRefreshGridView.getLoadingLayoutProxy().setLastUpdatedLabel(
                "刷新一下，更美好");
        mPullToRefreshGridView.getLoadingLayoutProxy().setRefreshingLabel(
                "正在刷新数据");
        mPullToRefreshGridView.getLoadingLayoutProxy()
                .setPullLabel("下拉刷新");
        mPullToRefreshGridView.getLoadingLayoutProxy().setReleaseLabel(
                "松开即可刷新");
        // 上拉、下拉设定
        mPullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshGridView.setOnRefreshListener(HotActivity.this);
        mPullToRefreshGridView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.btn_change));

        GridView mGridViewJingXuan = mPullToRefreshGridView.getRefreshableView();
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
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
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
        mGridViewJingXuan.setAdapter(ad);

        mGridViewJingXuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(HotActivity.this, VideoPlayActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_menu:
                startActivity(new Intent(this, DancesSearchActivity.class));
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
        mPullToRefreshGridView.onRefreshComplete();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
        mPullToRefreshGridView.onRefreshComplete();
    }
}
