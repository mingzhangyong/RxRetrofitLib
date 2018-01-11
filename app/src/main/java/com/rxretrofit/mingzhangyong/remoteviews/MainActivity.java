package com.rxretrofit.mingzhangyong.remoteviews;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.rxretrofit.mingzhangyong.rxretrofit.BaseActivity;
import com.rxretrofit.mingzhangyong.rxretrofit.BaseObserver;
import com.rxretrofit.mingzhangyong.rxretrofit.RestBase;
import com.rxretrofit.mingzhangyong.rxretrofit.RetrofitClient;
import com.rxretrofit.mingzhangyong.rxretrofit.RxSchedulersHelper;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.tv);


        RetrofitClient.getInstance("https://yyxsl.tianzhus.com/").create(AreaApi.class)
                .getNewsAreas()
                .compose(new RxSchedulersHelper<List<Area>>().io_main(this))
                .subscribe(new BaseObserver<List<Area>>() {
                    @Override
                    public void onSuccess(List<Area> areas) {
                        tv.setText(areas.get(1).getName());
                    }

                    @Override
                    public void onError(RestBase resetBody) {
                        Toast.makeText(MainActivity.this, resetBody.getDetail(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
