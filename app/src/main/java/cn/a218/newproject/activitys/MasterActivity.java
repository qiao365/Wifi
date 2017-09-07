package cn.a218.newproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.LinkedList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.MasterItemAdapter;
import cn.a218.newproject.models.MasterItem;

public class MasterActivity extends AutoLayoutActivity implements View.OnClickListener , PullToRefreshBase.OnRefreshListener2<ScrollView> {
    
    private MasterItemAdapter mAdapter;
    private ListView mListView;
    private PullToRefreshScrollView mPullToRefreshScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("达人秀");
        mPullToRefreshScrollView = (PullToRefreshScrollView) this.findViewById(R.id.mScrollView);
        mListView = (ListView) this.findViewById(R.id.mListView);
        // 刷新label的设置
        mPullToRefreshScrollView.getLoadingLayoutProxy().setLastUpdatedLabel(
                "刷新一下，更美好");
        mPullToRefreshScrollView.getLoadingLayoutProxy().setRefreshingLabel(
                "正在刷新数据");
        mPullToRefreshScrollView.getLoadingLayoutProxy()
                .setPullLabel("下拉刷新");
        mPullToRefreshScrollView.getLoadingLayoutProxy().setReleaseLabel(
                "松开即可刷新");
        // 上拉、下拉设定
        mPullToRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshScrollView.setOnRefreshListener(MasterActivity.this);
        mPullToRefreshScrollView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.btn_change));
        
        final List<MasterItem> mList = new LinkedList<MasterItem>();
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

        mAdapter = new MasterItemAdapter(MasterActivity.this, mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MasterActivity.this, MasterDancesActivity.class);
                startActivity(mIntent);
            }
        });

        mPullToRefreshScrollView.getRefreshableView().smoothScrollTo(0, 0);
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPullToRefreshScrollView.onRefreshComplete();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPullToRefreshScrollView.onRefreshComplete();
    }
}
