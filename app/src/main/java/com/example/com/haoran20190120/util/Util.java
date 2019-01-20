package com.example.com.haoran20190120.util;

import android.os.Handler;

import com.example.com.haoran20190120.api.Api;
import com.example.com.haoran20190120.model.MyModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Util {
    private Handler handler=new Handler();
    public void getData(final MyModel.ModelCallBack modelCallBack ){

        OkHttpClient build = new OkHttpClient.Builder().build();

        Request build1 = new Request.Builder().url(Api.url).build();

        Call call = build.newCall(build1);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                modelCallBack.error("错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        modelCallBack.success(string);
                    }
                });
            }


        });
    }

}
