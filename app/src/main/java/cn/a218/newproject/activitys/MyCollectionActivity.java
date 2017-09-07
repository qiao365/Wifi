package cn.a218.newproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.LinkedList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.MyCollectionItemAdapter;
import cn.a218.newproject.adapter.NearbyTeamItemAdapter;
import cn.a218.newproject.models.MasterItem;

public class MyCollectionActivity extends AutoLayoutActivity implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2<ListView> {

    private PullToRefreshListView mPullToRefreshListView;
    private ListView mListView;
    private MyCollectionItemAdapter mMyCollectionItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("我的收藏");
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
        mPullToRefreshListView.setOnRefreshListener(MyCollectionActivity.this);
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
        mMyCollectionItemAdapter = new MyCollectionItemAdapter(MyCollectionActivity.this, mList);
        mListView.setAdapter(mMyCollectionItemAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MyCollectionActivity.this,VideoPlayActivity.class));
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
