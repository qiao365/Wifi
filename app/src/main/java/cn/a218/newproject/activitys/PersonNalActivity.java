package cn.a218.newproject.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import cn.a218.newproject.R;

public class PersonNalActivity extends AutoLayoutActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_nal);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("更多");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
