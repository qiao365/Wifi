package cn.a218.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;
import cn.a218.newproject.R;
import cn.a218.newproject.models.VideoMsg;

/**
 * Created by Administrator on 2017/5/15.
 */

public abstract class ShowDancingAdapter extends BaseAdapter {
    private List<VideoMsg> stuList;
    private Context context;
    public ShowDancingAdapter() {}

    public ShowDancingAdapter(List<VideoMsg> stuList, Context context) {
        this.stuList = stuList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stuList==null?0:stuList.size();
    }

    @Override
    public VideoMsg getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.showdance_item_layout, parent, false);
            holder.mTextViewPlayMusic = (TextView)convertView.findViewById(R.id.mTextViewPlayMusic);
            holder.mTextViewShowDance = (TextView)convertView.findViewById(R.id.mTextViewShowDance);
            convertView.setTag(holder);
            //对于listview，注意添加这一行，即可在item上使用高度
            AutoUtils.autoSize(convertView);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        if(stuList.get(position).getiSplaying()){
            holder.mTextViewPlayMusic.setBackgroundResource(R.mipmap.icon_music_cover);
            holder.mTextViewPlayMusic.setText("");
        }else {
            holder.mTextViewPlayMusic.setText("播放");
            holder.mTextViewPlayMusic.setBackgroundResource(R.color.white);
        }

        holder.mTextViewPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(stuList.get(position),position);
            }
        });
        holder.mTextViewShowDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playDance(stuList.get(position),position);
            }
        });
        return convertView;
    }
    public abstract void playMusic(VideoMsg mVideoMsg,int position);
    public abstract void playDance(VideoMsg mVideoMsg,int position);
}
class ViewHolder {
    TextView mTextViewPlayMusic;
    TextView mTextViewShowDance;
}
