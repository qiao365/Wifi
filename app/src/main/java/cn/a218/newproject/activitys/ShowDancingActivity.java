package cn.a218.newproject.activitys;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.ShowDancingAdapter;
import cn.a218.newproject.models.VideoMsg;
import cn.a218.newproject.musicPlay.MusicService;

public class ShowDancingActivity extends AutoLayoutActivity implements View.OnClickListener {

    private ListView mHotListView;
    private ListView mDownListView;
    private RelativeLayout mLayoutDown;
    private RelativeLayout mLayoutLocal;
    private RelativeLayout mLayoutHot;
    private MusicService musicService;
    private int playPositionl = -1;
    private ShowDancingAdapter mShowDancingAdapter;
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
        Intent intent = new Intent(ShowDancingActivity.this, MusicService.class);
        startService(intent);
        bindService(intent, mServiceConnection, this.BIND_AUTO_CREATE);
    }

    public android.os.Handler handler = new android.os.Handler();
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (musicService.mp.isPlaying()) {

            } else {

            }
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
        setContentView(R.layout.activity_show_dancing);
        mHotListView = (ListView) findViewById(R.id.mHotListView);
        mDownListView = (ListView) findViewById(R.id.mDownListView);
        ScrollView mScrollView = (ScrollView) findViewById(R.id.mScrollView);

        mLayoutDown = (RelativeLayout) findViewById(R.id.mLayoutDown);
        mLayoutLocal = (RelativeLayout) findViewById(R.id.mLayoutLocal);
        mLayoutHot = (RelativeLayout) findViewById(R.id.mLayoutHot);

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
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mVideo.add(new VideoMsg());
        mShowDancingAdapter = new ShowDancingAdapter(mVideo, this){
            @Override
            public void playMusic(VideoMsg mVideoMsg,int position){
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
                mShowDancingAdapter.notifyDataSetChanged();
            }
            @Override
            public void playDance(VideoMsg mVideoMsg,int position){
                musicService.stop();
                startActivity(new Intent(ShowDancingActivity.this, FullScreenPlayActivity.class));
            }
        };
        mHotListView.setAdapter(mShowDancingAdapter);
        mDownListView.setAdapter(mShowDancingAdapter);

        View mListViewFooterHot = LayoutInflater.from(this).inflate(
                R.layout.listview_footer, null, false);
        mHotListView.addFooterView(mListViewFooterHot);

        View mListViewFooterDown = LayoutInflater.from(this).inflate(
                R.layout.listview_footer, null, false);
        mDownListView.addFooterView(mListViewFooterDown);

        mScrollView.smoothScrollTo(0, 0);
        mListViewFooterHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDancingActivity.this.onClick(mLayoutHot);
            }
        });
        mListViewFooterDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDancingActivity.this.onClick(mLayoutDown);
            }
        });

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.mLayoutDown:
                Intent mIntent = new Intent(this, WuquDancesActivity.class);
                mIntent.putExtra("name", "已下载舞曲");
                startActivity(mIntent);
                break;
            case R.id.mLayoutLocal:
                Intent mIntent1 = new Intent(this, WuquDancesActivity.class);
                mIntent1.putExtra("name", "本地舞曲");
                startActivity(mIntent1);
                break;
            case R.id.mLayoutHot:
                Intent mIntent3 = new Intent(this, WuquDancesActivity.class);
                mIntent3.putExtra("name", "热门舞曲");
                startActivity(mIntent3);
                break;
        }
    }
}
