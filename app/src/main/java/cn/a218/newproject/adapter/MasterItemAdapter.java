package cn.a218.newproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import cn.a218.newproject.models.MasterItem;

/**
 * Created by castl on 2016/5/13.
 */
public class MasterItemAdapter extends BaseAdapter {

    private List<MasterItem> objects = new ArrayList<MasterItem>();

    @SuppressWarnings("unused")
    private Context context;
    private LayoutInflater layoutInflater;

    public MasterItemAdapter(Context context, List<MasterItem> objects) {
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
        MasterItemAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_masre_item_layout, parent, false);
            viewHolder = new MasterItemAdapter.ViewHolder();
//            viewHolder.imgv = (ImageView) convertView.findViewById(R.id.imgv);
//            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
//            viewHolder.size = (TextView) convertView.findViewById(R.id.video_size);
//            viewHolder.duration = (TextView) convertView.findViewById(R.id.video_time_long);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (MasterItemAdapter.ViewHolder) convertView.getTag();
        }
        initializeViews((MasterItem) getItem(position), (MasterItemAdapter.ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(MasterItem object, MasterItemAdapter.ViewHolder holder) {
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

