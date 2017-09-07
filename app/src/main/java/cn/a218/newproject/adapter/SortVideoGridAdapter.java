package cn.a218.newproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.models.DanceSort;

public class SortVideoGridAdapter extends BaseAdapter {
	private List<DanceSort> mGalleryData = new ArrayList<DanceSort>();
	private LayoutInflater mInflater;
	private Context mContext;
	LinearLayout.LayoutParams params;

	public SortVideoGridAdapter(Context mContext2, List<DanceSort> mGalleryPhoneData) {
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
			convertView = mInflater.inflate(R.layout.activity_sort_gridview_item, parent, false);
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
		DanceSort mDanceSort = mGalleryData.get(position);
//		viewHolder.mIcon.setBackgroundColor( new RandomColor().randomColor());
		viewHolder.mContent.setText(mDanceSort.getName());
		return convertView;
	}

	class ViewHolder {
		protected ImageView mIcon;
		protected TextView mContent;
	}
}
