package cn.a218.newproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.models.DanceSort;
import cn.a218.newproject.utiles.TimeChange;

@SuppressLint({"InflateParams", "ViewHolder"})
public class DancesSearchItemAdapter extends BaseAdapter {

    private List<DanceSort> objects = new ArrayList<DanceSort>();

    @SuppressWarnings("unused")
    private Context context;
    private LayoutInflater layoutInflater;

    public DancesSearchItemAdapter(Context context, List<DanceSort> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public List<DanceSort> setObjects(List<DanceSort> objects) {
        return this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public DanceSort getItem(int position) {
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
            convertView = layoutInflater.inflate(R.layout.activity_dances_search_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgv = (ImageView) convertView.findViewById(R.id.mImageView);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.mTextView);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        initializeViews((DanceSort) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(DanceSort object, ViewHolder holder) {
//        Picasso.with(context)
//                .load("file://" + object.getUri_thumb())
//                .error(R.mipmap.ic_error)
//                .fit()
//                .centerCrop()
//                .into(holder.imgv);
        holder.tv.setText(object.getName());

    }

    protected class ViewHolder {
        private ImageView imgv;
        private TextView tv;
    }
}

