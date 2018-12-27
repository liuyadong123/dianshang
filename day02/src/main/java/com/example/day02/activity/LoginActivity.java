package com.example.day02.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.day02.R;
import com.example.day02.bean.UserBean;
import com.example.day02.modle.LoginModle;
import com.example.day02.presenter.LoginPresenter;
import com.example.day02.view.IloginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IloginView {
   private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
    }

    private void initData() {
        presenter=new LoginPresenter(this);
    }

    public void login(View view) {
        HashMap<String,String> params=new HashMap<>();
        params.put("mobile","18612991023");
        params.put("password","222222");
        if (presenter!=null){
            presenter.login(params);
        }
    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
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

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
