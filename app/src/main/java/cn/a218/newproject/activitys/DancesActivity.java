package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.LinkedList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.DanceItemAdapter;
import cn.a218.newproject.models.MasterItem;

public class DancesActivity extends AutoLayoutActivity implements View.OnClickListener {
    private RecyclerView recycler_view;
    private SwipeRefreshLayout swipe;
    private int contentQuantity = 20;
    private DanceItemAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dances);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        tv_info.setText("舞曲");
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new DanceItemAdapter(this);
        //刷新时执行的事件
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe.setRefreshing(false);
            }
        });
        recycler_view.setAdapter(mAdapter);
        recycler_view.setLayoutManager(layoutManager);
        final List<MasterItem> mList = new LinkedList<MasterItem>();
        mList.add(new MasterItem("又见山里红"));
        mList.add(new MasterItem("球服"));
        mList.add(new MasterItem("女人何苦为难女人"));
        mList.add(new MasterItem("山里红"));
        mList.add(new MasterItem("红尘情歌"));
        mList.add(new MasterItem("倒是你的错"));
        mList.add(new MasterItem("我在那里"));
        mList.add(new MasterItem("广场舞之恰恰恰"));
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
        mAdapter.setTextData(mList);

        mAdapter.setOnRecyclerViewItemClickListener(new DanceItemAdapter.onRecyclerViewItemClickListener() {
            @Override
            public void onRecyclerViewItemClick(View view, int postion) {
                Intent mIntent = new Intent(DancesActivity.this, SortItemActivity.class);
                mIntent.putExtra("name",mList.get(postion).getName());
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.moreTextView:
                startActivity(new Intent(this, MoreHotListActivity.class));
                break;
            default:
                finish();
        }
    }
}

