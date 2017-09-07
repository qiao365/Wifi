package cn.a218.newproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.models.MasterItem;

/**
 * Created by castl on 2016/5/13.
 */
public class DanceItemAdapter extends RecyclerView.Adapter<DanceItemAdapter.MyHolder> {
    private Context context;
    private List<MasterItem> textData = new ArrayList<>();
    private onRecyclerViewItemClickListener mItemClickListener;
    public DanceItemAdapter(Context context) {
        this.context = context;
    }

    public List<MasterItem> getTextData() {
        return textData;
    }

    public void setTextData(List<MasterItem> textData) {
        this.textData = textData;
        notifyDataSetChanged();
    }

    /**
     * setOnRecyclerViewItemClickListener
     * @param listener
     */
    public void setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener listener){
        this.mItemClickListener = listener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate( R.layout.activity_dance_item_layout,  parent, false);
        return new MyHolder(itemView,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(DanceItemAdapter.MyHolder holder, int position) {
        holder.setDataAndRefreshUI(textData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (textData != null)
            return textData.size();
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private TextView danceName;
        private onRecyclerViewItemClickListener mListener;

        public MyHolder(View itemView,onRecyclerViewItemClickListener mListener) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            this.mListener = mListener;
            mTextView = (TextView) itemView.findViewById(R.id.line_num);
            danceName = (TextView) itemView.findViewById(R.id.danceName);
            itemView.setOnClickListener(this);
        }

        public void setDataAndRefreshUI( MasterItem textdata, int position) {
            mTextView.setTextColor(Color.BLACK);
            mTextView.setText(position+1+"");
            if(position==0 || position == 1 || position == 2){
                mTextView.setTextColor(Color.RED);
            }
            danceName.setText(textdata.getName());
            // 自动加载图片
//            Picasso.with(context)
//                    .load(picdata.getUrl())
//                    .error(R.drawable.error_pic)
//                    .fit()
//                    .centerCrop()
//                    .into(mImageView);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onRecyclerViewItemClick(v,getPosition());
            }
        }
    }


    public interface onRecyclerViewItemClickListener {
        public void onRecyclerViewItemClick(View view,int postion);
    }
}
