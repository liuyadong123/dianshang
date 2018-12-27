package com.example.day01.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.day01.R;
import com.example.day01.bean.UserBean;
import com.example.day01.presenter.LoginPresenter;
import com.example.day01.view.IloginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity  implements IloginView {
 private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
    }

    private void initData() {
        presenter =new LoginPresenter(this);
    }

    public void login(View view) {
        HashMap<String,String> params =new HashMap<>();
        params.put("mobile","13522578752");
        params.put("password","222222");
        if (presenter!=null){
            presenter.login(params);
        }
    }

    @Override
    public void mobileErrorr(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdErrorr(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserBean userBean) {
        Toast.makeText(this,userBean.msg+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
