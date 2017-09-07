package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.NearbyTeamItemAdapter;
import cn.a218.newproject.models.BitmapEntity;

public class NearbyTeamActivity extends AutoLayoutActivity implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2<ListView> {

    private PullToRefreshListView mPullToRefreshListView;
    private ListView mListView;
    private NearbyTeamItemAdapter adapter;
    private List<BitmapEntity> bit = new ArrayList<BitmapEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_team);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("附近的舞队");
        mPullToRefreshListView = (PullToRefreshListView) this.findViewById(R.id.listview);
        mListView = mPullToRefreshListView.getRefreshableView();
        // 刷新label的设置
        mPullToRefreshListView.getLoadingLayoutProxy().setLastUpdatedLabel(
                "刷新一下，更美好");
        mPullToRefreshListView.getLoadingLayoutProxy().setRefreshingLabel(
                "正在刷新数据");
        mPullToRefreshListView.getLoadingLayoutProxy()
                .setPullLabel("下拉刷新");
        mPullToRefreshListView.getLoadingLayoutProxy().setReleaseLabel(
                "松开即可刷新");
        // 上拉、下拉设定
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshListView.setOnRefreshListener(NearbyTeamActivity.this);
        mPullToRefreshListView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.btn_change));

        adapter = new NearbyTeamItemAdapter(NearbyTeamActivity.this, bit);
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        bit.add(new BitmapEntity());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                finish();
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        mPullToRefreshListView.postDelayed(new Runnable() {

            @Override
            public void run() {
                mPullToRefreshListView.onRefreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        mPullToRefreshListView.postDelayed(new Runnable() {

            @Override
            public void run() {
                mPullToRefreshListView.onRefreshComplete();
            }
        }, 1000);
    }
}
