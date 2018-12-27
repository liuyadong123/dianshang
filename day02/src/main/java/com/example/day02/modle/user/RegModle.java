package com.example.day02.modle.user;

import android.os.Handler;

import com.example.day02.api.UserApi;
import com.example.day02.net.RequestCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegModle implements  IRegModle {
  Handler handler =new Handler();
    private RegCallback mRegcallback;

    @Override
    public void reg(HashMap<String, String> params) {
        OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        FormBody.Builder builder =new FormBody.Builder();
        for (Map.Entry<String, String> P:params.entrySet()){
            builder.add(P.getKey(), P.getValue());
        }

        Request request = new Request.Builder().url(UserApi.USER_REG).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (mRegcallback!=null){
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                      mRegcallback.onFailure("请求失败");
                     }
                 });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  if (mRegcallback!=null){
                      final String result = response.body().string();
                      handler.post(new Runnable() {
                          @Override
                          public void run() {
                            mRegcallback.onRespones(result);
                          }
                      });


                  }
            }
        });
    }
    public  void login(HashMap<String,String> params){

    }
    public void setmRegcallback(RegCallback mRegcallback){
        this.mRegcallback=mRegcallback;
        
    }
    public interface  RegCallback{
         void onFailure(String msg);
         void onRespones(String result);
    }

}
