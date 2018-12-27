package com.example.day02.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.day02.R;
import com.example.day02.presenter.userpresenter.RegPresenter;
import com.example.day02.view.user.IRegView;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements IRegView {
   private RegPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initData();
    }

    private void initData() {
        presenter=new RegPresenter(this);
    }

    public void regBtn(View view) {
        HashMap<String,String> params=new HashMap<>();
        params.put("mobile","13522578758");
        params.put("password","05274016");
        if (presenter!=null){
            presenter.register(params);
        }
    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String result) {
        Toast.makeText(this,result+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.destroy();
        }
    }
}
