package cn.a218.newproject.adapter;

/**
 * Created by Administrator on 2017/5/19.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.models.MasterItem;


@SuppressLint({"InflateParams", "ViewHolder"})
public class MyCollectionItemAdapter extends BaseAdapter {

    private List<MasterItem> objects = new ArrayList<MasterItem>();

    @SuppressWarnings("unused")
    private Context context;
    private LayoutInflater layoutInflater;

    public MyCollectionItemAdapter(Context context, List<MasterItem> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public List<MasterItem> setObjects(List<MasterItem> objects) {
        return this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public MasterItem getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 数据量过大可能出现错乱，暂时不用缓存策略
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_mycollection_item_layout, parent, false);
            viewHolder = new ViewHolder();
//            viewHolder.imgv = (ImageView) convertView.findViewById(R.id.imgv);
//            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
//            viewHolder.size = (TextView) convertView.findViewById(R.id.video_size);
//            viewHolder.duration = (TextView) convertView.findViewById(R.id.video_time_long);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        initializeViews((MasterItem) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(MasterItem object, ViewHolder holder) {
//        Picasso.with(context)
//                .load("file://" + object.getUri_thumb())
//                .error(R.mipmap.ic_error)
//                .fit()
//                .centerCrop()
//                .into(holder.imgv);
//        holder.tv.setText(object.getName());
//        holder.size.setText("");
//        holder.duration.setText(TimeChange.setTime(object.getDuration()));

    }

    protected class ViewHolder {
        private ImageView imgv;
        private TextView tv;
        private TextView size;
        private TextView duration;
    }
}


