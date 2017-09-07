package cn.a218.newproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TabHost;

import com.zhy.autolayout.AutoLayoutActivity;

import cn.a218.newproject.R;
import cn.a218.newproject.cn.a218.activity.fragment.HomeMain1Fragment;
import cn.a218.newproject.cn.a218.activity.fragment.HomeMain2Fragment;
import cn.a218.newproject.cn.a218.activity.fragment.HomeMain4Fragment;
import cn.a218.newproject.cn.a218.activity.fragment.HomeMain5Fragment;
import cn.a218.newproject.views.SelectPicPopupWindow;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HomeMain1Fragment mHomeMain1Fragment;
    private HomeMain2Fragment mHomeMain2Fragment;
    private HomeMain4Fragment mHomeMain4Fragment;
    private HomeMain5Fragment mHomeMain5Fragment;
    private ImageView btn_home_pre;
    private ImageView btn_jiaoxue_pre;
    private ImageView btn_saishi_pre;
    private ImageView btn_wode_pre;
    private FrameLayout fmpan;
    private FrameLayout centerBtn;
    private LayoutInflater inflater;
    //自定义的弹出框类
    private SelectPicPopupWindow menuWindow;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        centerBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (menuWindow != null && menuWindow.isShowing()) {
                    menuWindow.dismiss();
                } else {
                    showWindow(fmpan);
                }
            }

        });

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        mHomeMain1Fragment = new HomeMain1Fragment();
        transaction.replace(R.id.fragment_stub, mHomeMain1Fragment);
        transaction.commit();
    }

    private void initView() {
        inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fmpan = (FrameLayout) findViewById(R.id.bottom);
        centerBtn = (FrameLayout) findViewById(R.id.home_center_btn);
        btn_home_pre = (ImageView) findViewById(R.id.btn_home_pre);
        btn_jiaoxue_pre = (ImageView) findViewById(R.id.btn_jiaoxue_pre);
        btn_saishi_pre = (ImageView) findViewById(R.id.btn_saishi_pre);
        btn_wode_pre = (ImageView) findViewById(R.id.btn_wode_pre);
        FrameLayout FrameLayout1 = (FrameLayout) findViewById(R.id.tab1);
        FrameLayout FrameLayout2 = (FrameLayout) findViewById(R.id.tab2);
        FrameLayout FrameLayout4 = (FrameLayout) findViewById(R.id.tab4);
        FrameLayout FrameLayout5 = (FrameLayout) findViewById(R.id.tab5);
        FrameLayout1.setOnClickListener(this);
        FrameLayout2.setOnClickListener(this);
        FrameLayout4.setOnClickListener(this);
        FrameLayout5.setOnClickListener(this);
    }

    /**
     * 显示
     *
     * @param parent
     */
    private void showWindow(View parent) {
        if (menuWindow == null) {
            //实例化SelectPicPopupWindow
            menuWindow = new SelectPicPopupWindow(MainActivity.this, this);
        }
        // 使其聚集
        menuWindow.setFocusable(true);
        // 设置允许在外点击消失
        menuWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        menuWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示窗口
        menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
    }

    @Override
    public void onClick(View view) {
        hideall();
        switch (view.getId()) {
            case R.id.tab1:
                btn_home_pre.setVisibility(View.VISIBLE);
                transaction = fragmentManager.beginTransaction();
                mHomeMain1Fragment = new HomeMain1Fragment();
                transaction.replace(R.id.fragment_stub, mHomeMain1Fragment);
                transaction.commit();
                break;

            case R.id.tab2:
                btn_jiaoxue_pre.setVisibility(View.VISIBLE);
                transaction = fragmentManager.beginTransaction();
                mHomeMain2Fragment = new HomeMain2Fragment();
                transaction.replace(R.id.fragment_stub, mHomeMain2Fragment);
                transaction.commit();
                break;
            case R.id.tab4:
                btn_saishi_pre.setVisibility(View.VISIBLE);
                transaction = fragmentManager.beginTransaction();
                mHomeMain4Fragment = new HomeMain4Fragment();
                transaction.replace(R.id.fragment_stub, mHomeMain4Fragment);
                transaction.commit();
                break;
            case R.id.tab5:
                btn_wode_pre.setVisibility(View.VISIBLE);
                transaction = fragmentManager.beginTransaction();
                mHomeMain5Fragment = new HomeMain5Fragment();
                transaction.replace(R.id.fragment_stub, mHomeMain5Fragment);
                transaction.commit();
                break;
            case R.id.btn_take_photo:
                startActivity(new Intent(this, ShowDancingActivity.class));
                menuWindow.dismiss();
                break;
            case R.id.btn_pick_photo:
                startActivity(new Intent(this, LocalUploadActivity.class));
                menuWindow.dismiss();
                break;
            default:

                break;
        }
    }

    private void hideall() {
        btn_home_pre.setVisibility(View.GONE);
        btn_jiaoxue_pre.setVisibility(View.GONE);
        btn_saishi_pre.setVisibility(View.GONE);
        btn_wode_pre.setVisibility(View.GONE);
    }
}
