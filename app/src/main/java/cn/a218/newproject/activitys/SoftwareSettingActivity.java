package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import cn.a218.newproject.R;
import cn.a218.newproject.views.SwitchView;

public class SoftwareSettingActivity extends AutoLayoutActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_setting);
        initView();
    }

    private void initView() {
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("软件设置");
        SwitchView SwitchView1 = (SwitchView) findViewById(R.id.SwitchView1);
        SwitchView SwitchView2 = (SwitchView) findViewById(R.id.SwitchView2);
        SwitchView SwitchView3 = (SwitchView) findViewById(R.id.SwitchView3);
        SwitchView1.setState(true);
//        SwitchView1.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
//            @Override
//            public void toggleToOn() {
//
//            }
//
//            @Override
//            public void toggleToOff() {
//
//            }
//        });
//        SwitchView2.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
//            @Override
//            public void toggleToOn() {
//
//            }
//
//            @Override
//            public void toggleToOff() {
//
//            }
//        });
//        SwitchView3.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
//            @Override
//            public void toggleToOn() {
//
//            }
//
//            @Override
//            public void toggleToOff() {
//
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btnBack:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
