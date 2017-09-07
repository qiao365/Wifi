package cn.a218.newproject.cn.a218.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.a218.newproject.R;
import cn.a218.newproject.activitys.DraftsActivity;
import cn.a218.newproject.activitys.MyCollectionActivity;
import cn.a218.newproject.activitys.MyDanceTeamActivity;
import cn.a218.newproject.activitys.MyWorkSpaceActivity;
import cn.a218.newproject.activitys.PersonNalActivity;
import cn.a218.newproject.activitys.SoftwareSettingActivity;
import cn.a218.newproject.activitys.WatchHistoryActivity;

/**
 * 我的
 *
 * @author CJQ
 */
public class HomeMain5Fragment extends Fragment implements View.OnClickListener {
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main5, null);

        WebView mWebView = (WebView) view.findViewById(R.id.mWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.loadUrl("http://192.168.9.1:7878/video/video.php");
        mWebView.loadUrl("http://192.168.9.1:7878/qingzang/gtyx.htm");

        mWebView.setWebViewClient(new HelloWebViewClient());

        view.findViewById(R.id.mLayout1).setOnClickListener(this);
        view.findViewById(R.id.mLayout2).setOnClickListener(this);
        view.findViewById(R.id.mLayout3).setOnClickListener(this);
        view.findViewById(R.id.mLayout4).setOnClickListener(this);
        view.findViewById(R.id.mLayout5).setOnClickListener(this);
        view.findViewById(R.id.mLayout6).setOnClickListener(this);
        view.findViewById(R.id.mLayout7).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLayout1:
                startActivity(new Intent(getContext(), PersonNalActivity.class));
                break;
            case R.id.mLayout2:
                startActivity(new Intent(getContext(), MyWorkSpaceActivity.class));
                break;
            case R.id.mLayout3:
                startActivity(new Intent(getContext(), DraftsActivity.class));
                break;
            case R.id.mLayout4:
                startActivity(new Intent(getContext(), MyDanceTeamActivity.class));
                break;
            case R.id.mLayout5:
                startActivity(new Intent(getContext(), MyCollectionActivity.class));
                break;
            case R.id.mLayout6:
                startActivity(new Intent(getContext(), WatchHistoryActivity.class));
                break;
            case R.id.mLayout7:
                startActivity(new Intent(getContext(), SoftwareSettingActivity.class));
                break;
            default:

                break;
        }
    }
}
