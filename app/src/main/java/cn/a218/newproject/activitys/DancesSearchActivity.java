package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.adapter.DancesSearchItemAdapter;
import cn.a218.newproject.adapter.SortVideoGridAdapter;
import cn.a218.newproject.models.DanceSort;
import cn.a218.newproject.views.tag.Tag;
import cn.a218.newproject.views.tag.TagListView;
import cn.a218.newproject.views.tag.TagView;

public class DancesSearchActivity extends AutoLayoutActivity implements View.OnClickListener {

    private TagListView mTagListView;
    private ListView mListView;
    private LinearLayout mTagViewAll;
    private EditText index_search_edit;
    private TextView mTextViewSearch;
    private ImageView iv_back;
    private final List<Tag> mTags = new ArrayList<Tag>();
    private final String[] titles = {"广场舞课堂", "养生课堂的第一次讲解", "大妈小到就", "小清新",
            "梦中的妈妈", "红军吗", "输入法", "招财猫", "最美应用", "AndevUI", "美体计划"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dances_search);
        initView();
    }

    private void initView() {
        mTagListView = (TagListView) findViewById(R.id.tagview);
        mTagViewAll = (LinearLayout) findViewById(R.id.mTagViewAll);
        mListView = (ListView) findViewById(R.id.mListView);
        index_search_edit = (EditText) findViewById(R.id.index_search_edit);
        mTextViewSearch = (TextView) findViewById(R.id.mTextViewSearch);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        setUpData();
        mTagListView.setTags(mTags);

        index_search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    onClick(iv_back);
                }else {
                    onClick(mTextViewSearch);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView tagView, Tag tag) {
                Intent mIntent = new Intent(DancesSearchActivity.this, SortItemActivity.class);
                mIntent.putExtra("name", tag.getTitle());
                startActivity(mIntent);
            }
        });
    }

    private void setUpData() {
        for (int i = 0; i < 10; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(titles[i]);
            mTags.add(tag);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (mListView.getVisibility() == View.VISIBLE) {
                    mTagViewAll.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.GONE);
                }else {
                    finish();
                }
                break;
            case R.id.mTextViewSearch:
                mTagViewAll.setVisibility(View.GONE);
                mListView.setVisibility(View.VISIBLE);
                final ArrayList<DanceSort> mdata = new ArrayList<DanceSort>();
                mdata.add(new DanceSort("肚皮舞"));
                mdata.add(new DanceSort("兔子舞"));
                mdata.add(new DanceSort("排舞"));
                mdata.add(new DanceSort("秧歌"));
                mdata.add(new DanceSort("新疆舞"));
                mdata.add(new DanceSort("傣族舞"));
                mdata.add(new DanceSort("吉特巴"));
                mdata.add(new DanceSort("吉特巴16步"));
                mdata.add(new DanceSort("瘦身"));
                mdata.add(new DanceSort("双人舞"));
                mdata.add(new DanceSort("美食"));
                mdata.add(new DanceSort("鬼步舞"));
                mdata.add(new DanceSort("发型"));
                mdata.add(new DanceSort("恰恰"));
                mdata.add(new DanceSort("扇子舞"));
                mdata.add(new DanceSort("探戈"));
                mdata.add(new DanceSort("爵士舞"));
                mdata.add(new DanceSort("街舞"));
                mdata.add(new DanceSort("民族舞"));
                mdata.add(new DanceSort("伦巴"));

                DancesSearchItemAdapter ad = new DancesSearchItemAdapter(this, mdata);
                mListView.setAdapter(ad);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent mIntent = new Intent(DancesSearchActivity.this, SortItemActivity.class);
                        mIntent.putExtra("name", mdata.get(position).getName());
                        startActivity(mIntent);
                    }
                });
                break;
        }
    }
}
