package cn.a218.newproject.activitys;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.NearbyTeamItemAdapter;
import cn.a218.newproject.adapter.ShowDancingAdapter;
import cn.a218.newproject.models.BitmapEntity;
import cn.a218.newproject.models.VideoMsg;
import cn.a218.newproject.musicPlay.MusicService;

public class WuquDancesActivity extends AutoLayoutActivity implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2<ListView> {

    private PullToRefreshListView mPullToRefreshListView;
    private ListView mListView;
    private ShowDancingAdapter adapter;
    private MusicService musicService;
    private int playPositionl = -1;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicService = ((MusicService.MyBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };

    private void bindServiceConnection() {
        Intent intent = new Intent(WuquDancesActivity.this, MusicService.class);
        startService(intent);
        bindService(intent, mServiceConnection, this.BIND_AUTO_CREATE);
    }

    public android.os.Handler handler = new android.os.Handler();
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            if (musicService.mp.isPlaying()) {
//
//            } else {
//
//            }
//            musicTime.setText(time.format(musicService.mp.getCurrentPosition()) + "/"
//                    + time.format(musicService.mp.getDuration()));
//            seekBar.setProgress(musicService.mp.getCurrentPosition());
//            musicService.mp.seekTo(seekBar.getProgress());

            handler.postDelayed(runnable, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuqu_dances);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        String title = getIntent().getExtras().getString("name", "");
        tv_info.setText(title);
        mPullToRefreshListView = (PullToRefreshListView) this.findViewById(R.id.listview);
        mListView = mPullToRefreshListView.getRefreshableView();
        // 上拉、下拉设定
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        mPullToRefreshListView.setOnRefreshListener(WuquDancesActivity.this);
        mPullToRefreshListView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.btn_change));
        final List<VideoMsg> mVideo = new ArrayList<>();
        mVideo.add(new VideoMsg("荷塘月色"));
        mVideo.add(new VideoMsg("火苗"));
        mVideo.add(new VideoMsg("十送红军"));
        mVideo.add(new VideoMsg("一物降一物"));
        mVideo.add(new VideoMsg("爱的供养"));
        mVideo.add(new VideoMsg("春风"));
        mVideo.add(new VideoMsg("映山红"));
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        adapter = new ShowDancingAdapter(mVideo, this) {
            @Override
            public void playMusic(VideoMsg mVideoMsg, int position) {
                for (VideoMsg videoMsg : mVideo) {
                    videoMsg.setiSplaying(false);
                }
                mVideo.get(position).setiSplaying(true);
                if (position == playPositionl && musicService.mp.isPlaying()){
                    musicService.playOrPause();
                    mVideo.get(position).setiSplaying(false);
                }else {
                    playPositionl = position;
                    musicService.playMusic("http://abv.cn/music/光辉岁月.mp3");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void playDance(VideoMsg mVideoMsg, int position) {
                musicService.stop();
                startActivity(new Intent(WuquDancesActivity.this, FullScreenPlayActivity.class));
            }
        };
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        if (musicService == null) {
            Log.d("hint", "ready to new MusicService");
            musicService = new MusicService();
            Log.d("hint", "finish to new MusicService");
            bindServiceConnection();
//        musicService.playOrPause();
        }
        super.onStart();
    }

    @Override
    public void onDestroy() {
        musicService.stop();
//        musicService.onDestroy();
        unbindService(mServiceConnection);
//        musicService = null;
        super.onDestroy();
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
