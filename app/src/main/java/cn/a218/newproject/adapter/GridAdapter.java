package cn.a218.newproject.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhy.autolayout.utils.AutoUtils;

import cn.a218.newproject.R;
import cn.a218.newproject.models.VideoMsg;

public class GridAdapter extends BaseAdapter {
    private List<VideoMsg> mGalleryData = new ArrayList<VideoMsg>();
    private LayoutInflater mInflater;
    private Context mContext;
    LinearLayout.LayoutParams params;

    public GridAdapter(Context mContext2, List<VideoMsg> mGalleryPhoneData) {
        this.mGalleryData = mGalleryPhoneData;
        this.mContext = mContext2;
    }

    public int getCount() {
        return mGalleryData.size();
    }

    public Object getItem(int position) {
        return mGalleryData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.home_fragment_gridview_item, parent, false);
            viewHolder = new ViewHolder();
            // construct an item tag
            viewHolder.mIcon = (ImageView) convertView
                    .findViewById(R.id.grid_icon);
            viewHolder.mContent = (TextView) convertView
                    .findViewById(R.id.grid_name);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//		Picasso.with(convertView.getContext())
//				.load("http://p4.so.qhimg.com/t0178acee482dd55aa4.jpg")
//				.error(R.mipmap.ic_error)
//				.fit()
//				.centerCrop()
//				.into(viewHolder.mIcon);
        return convertView;
    }

    class ViewHolder {
        protected ImageView mIcon;
        protected TextView mContent;
    }
}
