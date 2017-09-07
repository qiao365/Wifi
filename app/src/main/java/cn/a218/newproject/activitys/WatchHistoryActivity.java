package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.LinkedList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.MyCollectionItemAdapter;
import cn.a218.newproject.models.MasterItem;

public class WatchHistoryActivity extends AutoLayoutActivity implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2<ListView> {

    private PullToRefreshListView mPullToRefreshListView;
    private ListView mListView;
    private MyCollectionItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_history);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        LinearLayout centerNoData = (LinearLayout) findViewById(R.id.centerNoData);
        centerNoData.setVisibility(View.GONE);
        tv_info.setText("观看历史");
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
        mPullToRefreshListView.setOnRefreshListener(WatchHistoryActivity.this);
        mPullToRefreshListView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.btn_change));

        List<MasterItem> mList = new LinkedList<MasterItem>();
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mList.add(new MasterItem());
        mAdapter = new MyCollectionItemAdapter(WatchHistoryActivity.this, mList);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(WatchHistoryActivity.this,VideoPlayActivity.class));
            }
        });

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

    @Override
    public void onClick(View view) {
        finish();
    }
}
