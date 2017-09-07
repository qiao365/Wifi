package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.GridAdapter;
import cn.a218.newproject.adapter.SortVideoGridAdapter;
import cn.a218.newproject.models.DanceSort;
import cn.a218.newproject.models.VideoMsg;

public class SortActivity extends AutoLayoutActivity implements View.OnClickListener {

    List<DanceSort> mGalleryPhoneData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("舞曲分类");
        GridView mGridViewJingXuan = (GridView) findViewById(R.id.mGridViewJingXuan);
        mGalleryPhoneData = new ArrayList<DanceSort>();
        mGalleryPhoneData.add(new DanceSort("肚皮舞"));
        mGalleryPhoneData.add(new DanceSort("兔子舞"));
        mGalleryPhoneData.add(new DanceSort("排舞"));
        mGalleryPhoneData.add(new DanceSort("秧歌"));
        mGalleryPhoneData.add(new DanceSort("新疆舞"));
        mGalleryPhoneData.add(new DanceSort("傣族舞"));
        mGalleryPhoneData.add(new DanceSort("吉特巴"));
        mGalleryPhoneData.add(new DanceSort("吉特巴16步"));
        mGalleryPhoneData.add(new DanceSort("瘦身"));
        mGalleryPhoneData.add(new DanceSort("双人舞"));
        mGalleryPhoneData.add(new DanceSort("美食"));
        mGalleryPhoneData.add(new DanceSort("鬼步舞"));
        mGalleryPhoneData.add(new DanceSort("发型"));
        mGalleryPhoneData.add(new DanceSort("恰恰"));
        mGalleryPhoneData.add(new DanceSort("扇子舞"));
        mGalleryPhoneData.add(new DanceSort("探戈"));
        mGalleryPhoneData.add(new DanceSort("爵士舞"));
        mGalleryPhoneData.add(new DanceSort("街舞"));
        mGalleryPhoneData.add(new DanceSort("民族舞"));
        mGalleryPhoneData.add(new DanceSort("伦巴"));

        SortVideoGridAdapter ad = new SortVideoGridAdapter(this, mGalleryPhoneData);
        mGridViewJingXuan.setAdapter(ad);
        mGridViewJingXuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(SortActivity.this, SortItemActivity.class);
                mIntent.putExtra("name", mGalleryPhoneData.get(i).getName());
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
