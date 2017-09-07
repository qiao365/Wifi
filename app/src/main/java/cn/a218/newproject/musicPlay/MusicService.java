package cn.a218.newproject.musicPlay;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by West on 2017/5/19
 */
public class MusicService extends Service {


//    private String[] musicDir = new String[]{Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music/汪苏泷 - 累不累.mp3"};

//                Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music/汪苏泷 - 累不累.mp3"
//    private int musicIndex = 1;

    public final IBinder binder = new MyBinder();
    public class MyBinder extends Binder{
        public MusicService getService() {
            return MusicService.this;
        }
    }
    public static MediaPlayer mp = new MediaPlayer();
    public MusicService() {
        try {
            mp.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music/仙剑奇侠传六-主题曲-《剑客不能说》.mp3");
            //mp.setDataSource(Environment.getDataDirectory().getAbsolutePath()+"/You.mp3");
            mp.prepare();
        } catch (Exception e) {
            Log.d("hint","can't get to the song");
            e.printStackTrace();
        }
    }
    public void playOrPause() {
        if(mp.isPlaying()){
            mp.pause();
        } else {
            mp.start();
        }
    }
    public void stop() {
        if(mp != null && mp.isPlaying()) {
            stopPlay();
            try {
                mp.prepare();
                mp.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playMusic(String url) {
        if(mp != null) {
            stopPlay();
            try {
                mp.reset();
                mp.setDataSource(url);
                mp.prepare();
                mp.seekTo(0);
                mp.start();
            } catch (Exception e) {
                Log.d("hint", "can't jump pre music");
                e.printStackTrace();
            }
        }
    }

    private void stopPlay(){
        try {
            if (mp.isPlaying()){
                mp.stop();
            }
        } catch (IllegalStateException e) {

        }
    }

    @Override
    public void onDestroy() {
        stopPlay();
        mp.release();
        super.onDestroy();
    }

    /**
     * onBind 是 Service 的虚方法，因此我们不得不实现它。
     * 返回 null，表示客服端不能建立到此服务的连接。
     */
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
