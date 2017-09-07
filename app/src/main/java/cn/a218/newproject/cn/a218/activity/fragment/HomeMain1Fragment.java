package cn.a218.newproject.cn.a218.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
//import com.youth.banner.Banner;
//import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cn.a218.newproject.R;
import cn.a218.newproject.activitys.DancesActivity;
import cn.a218.newproject.activitys.DancesSearchActivity;
import cn.a218.newproject.activitys.HotActivity;
import cn.a218.newproject.activitys.MasterActivity;
import cn.a218.newproject.activitys.NewestActivity;
import cn.a218.newproject.activitys.SortActivity;
import cn.a218.newproject.activitys.VideoPlayActivity;
import cn.a218.newproject.activitys.WatchHistoryActivity;
import cn.a218.newproject.adapter.GridAdapter;
import cn.a218.newproject.models.VideoMsg;
//import cn.a218.newproject.utiles.PicassoImageLoader;
import cn.a218.newproject.views.MyGridView;


/**
 * 首页
 *
 * @author CJQ
 */
public class HomeMain1Fragment extends Fragment implements View.OnClickListener ,PullToRefreshBase.OnRefreshListener2<ScrollView> {
    PullToRefreshScrollView mPullRefreshScrollView;
    EditText index_search_edit;
//    Banner banner;
    List<String> images = new ArrayList<>();
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main1, null);

        WebView mWebView = (WebView) view.findViewById(R.id.mWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.loadUrl("http://192.168.9.1:7878/index/frist.php");
//        mWebView.loadUrl("http://192.168.9.1:7878/qingzang/index.html");
        mWebView.loadUrl("http://192.168.9.1:7878/qingzang/main.html");
        mWebView.setWebViewClient(new HelloWebViewClient());

        MyGridView mGridViewJingXuan = (MyGridView) view.findViewById(R.id.mGridViewJingXuan);
        mPullRefreshScrollView = (PullToRefreshScrollView) view.findViewById(R.id.mScrollView);
        // 刷新label的设置
        mPullRefreshScrollView.getLoadingLayoutProxy().setLastUpdatedLabel(
                "刷新一下，更美好");
		mPullRefreshScrollView.getLoadingLayoutProxy().setRefreshingLabel(
				"正在刷新数据");
        mPullRefreshScrollView.getLoadingLayoutProxy()
                .setPullLabel("下拉刷新");
        mPullRefreshScrollView.getLoadingLayoutProxy().setReleaseLabel(
                "松开即可刷新");
        // 上拉、下拉设定
        mPullRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullRefreshScrollView.setOnRefreshListener(this);
        mPullRefreshScrollView.getLoadingLayoutProxy().setLoadingDrawable(getActivity().getResources().getDrawable(R.mipmap.btn_change));
        
        index_search_edit = (EditText) view.findViewById(R.id.index_search_edit);
        index_search_edit.setOnClickListener(this);
        view.findViewById(R.id.home_tag_hot).setOnClickListener(this);
        view.findViewById(R.id.home_tag_sort).setOnClickListener(this);
        view.findViewById(R.id.home_tag_dances).setOnClickListener(this);
        view.findViewById(R.id.home_tag_master).setOnClickListener(this);
        view.findViewById(R.id.home_tag_newest).setOnClickListener(this);
        view.findViewById(R.id.home_tag_history).setOnClickListener(this);

//        banner = (Banner) view.findViewById(R.id.banner);
//        //设置图片加载器
//        banner.setImageLoader(new PicassoImageLoader());
//        //设置图片集合
//        images.add("http://p3.ifengimg.com/fck/2016_33/093aefe62ac8482_w1266_h844.jpg");
//        images.add("http://heilongjiang.sinaimg.cn/2015/0707/U10057P1274DT20150707103838.jpg");
//        images.add("http://sddy.wenming.cn/jjdy/201409/W020140923295085579436.jpg");
//        banner.setImages(images);
//        banner.releaseBanner();
//        //banner设置方法全部调用完毕时最后调用
//        banner.start();
//
//        banner.setOnBannerListener(new OnBannerListener() {
//            @Override
//            public void OnBannerClick(int position) {
//
//            }
//        });

        List<VideoMsg> mGalleryPhoneData = new ArrayList<VideoMsg>();
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        mGalleryPhoneData.add(new VideoMsg());
        GridAdapter ad = new GridAdapter(view.getContext(), mGalleryPhoneData);
        mGridViewJingXuan.setAdapter(ad);
        mPullRefreshScrollView.getRefreshableView().smoothScrollTo(0, 0);
        mGridViewJingXuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), VideoPlayActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.index_search_edit:
                startActivity(new Intent(getContext(), DancesSearchActivity.class));
                break;
            case R.id.home_tag_hot:
                startActivity(new Intent(getContext(), HotActivity.class));
                break;
            case R.id.home_tag_sort:
                startActivity(new Intent(getContext(), SortActivity.class));
                break;
            case R.id.home_tag_dances:
                startActivity(new Intent(getContext(), DancesActivity.class));
                break;
            case R.id.home_tag_master:
                startActivity(new Intent(getContext(), MasterActivity.class));
                break;
            case R.id.home_tag_newest:
                startActivity(new Intent(getContext(), NewestActivity.class));
                break;
            case R.id.home_tag_history:
                startActivity(new Intent(getContext(), WatchHistoryActivity.class));
                break;
            default:

                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPullRefreshScrollView.onRefreshComplete();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
        mPullRefreshScrollView.onRefreshComplete();
    }
}
