package com.example.day03.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UserUtils {

     public  String getRequest(String equirl){
          String result="";
         try {
             URL url =new URL(equirl);
             HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
             httpURLConnection.setRequestMethod("GET");
             httpURLConnection.setReadTimeout(5000);
             httpURLConnection.setConnectTimeout(5000);
             int responseCode = httpURLConnection.getResponseCode();
             if (responseCode==200){
                 result=stream2String(httpURLConnection.getInputStream());
             }
         } catch (Exception e) {
             e.printStackTrace();
         }

         return result;
     }
      public interface NetCallBack<T>{
         void success(T t);
         void onFile(String msg);
      }
      public  <T> T getRequest2(String equirl,Class clazzbean){
          String request = getRequest(equirl);
          Object obj;
          obj = new Gson().fromJson(request, clazzbean);
          return (T) obj;
      }
      public void getRequest3(String equirl, final Class clazzbean, final NetCallBack callBack){
          new AsyncTask<String, Void, Object>() {
              @Override
              protected Object doInBackground(String... strings) {
                  return getRequest2(strings[0],clazzbean);
              }

              @Override
              protected void onPostExecute(Object o) {
                  super.onPostExecute(o);
                  if (o!=null){
                      callBack.onFile("请求失败");
                  }else {
                      callBack.success(o);
                  }
              }

          }.execute(equirl);

      }

    private String stream2String(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader hh = new InputStreamReader(inputStream);
        BufferedReader rr = new BufferedReader(hh);
        for (String tmp=rr.readLine();tmp!=null;tmp=rr.readLine()){
             stringBuilder.append(tmp);
        }

           return  stringBuilder.toString();

    }
}
