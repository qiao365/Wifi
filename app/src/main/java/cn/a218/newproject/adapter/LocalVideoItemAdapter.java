package cn.a218.newproject.adapter;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;
import com.zhy.autolayout.utils.AutoUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.a218.newproject.R;
import cn.a218.newproject.models.BitmapEntity;
import cn.a218.newproject.utiles.TimeChange;

@SuppressLint({"InflateParams", "ViewHolder"})
public class LocalVideoItemAdapter extends BaseAdapter {

    private List<BitmapEntity> objects = new ArrayList<BitmapEntity>();

    @SuppressWarnings("unused")
    private Context context;
    private LayoutInflater layoutInflater;

    public LocalVideoItemAdapter(Context context, List<BitmapEntity> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public List<BitmapEntity> setObjects(List<BitmapEntity> objects) {
        return this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public BitmapEntity getItem(int position) {
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
            convertView = layoutInflater.inflate(R.layout.activity_local_upload_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgv = (ImageView) convertView.findViewById(R.id.imgv);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            viewHolder.size = (TextView) convertView.findViewById(R.id.video_size);
            viewHolder.duration = (TextView) convertView.findViewById(R.id.video_time_long);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        initializeViews((BitmapEntity) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(BitmapEntity object, ViewHolder holder) {
        Picasso.with(context)
                .load("file://" + object.getUri_thumb())
                .error(R.mipmap.ic_error)
                .fit()
                .centerCrop()
                .into(holder.imgv);
        holder.tv.setText(object.getName());
        holder.size.setText(TimeChange.bytes2kb(object.getSize()) + "");
        holder.duration.setText(TimeChange.setTime(object.getDuration()));

    }

    protected class ViewHolder {
        private ImageView imgv;
        private TextView tv;
        private TextView size;
        private TextView duration;
    }
}

