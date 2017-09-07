package cn.a218.newproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import cn.a218.newproject.R;
import cn.a218.newproject.cn.a218.activity.fragment.HomeMain1Fragment;

public class MyDanceTeamActivity extends AutoLayoutActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dance_ranks);
        TextView tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setText("我的舞队");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.searchTeam:
                startActivity(new Intent(this, NearbyTeamActivity.class));
                break;
            case R.id.createTeam:
                startActivity(new Intent(this, TeamCreateActivity.class));
                break;
            default:
                finish();
        }
    }
}
