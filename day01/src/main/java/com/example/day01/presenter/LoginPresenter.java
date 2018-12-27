package com.example.day01.presenter;


import com.example.day01.bean.UserBean;
import com.example.day01.modle.LoginModle;
import com.example.day01.net.RequestCallback;
import com.example.day01.utils.ValidatorUtils;
import com.example.day01.view.IloginView;

import java.util.HashMap;

public class LoginPresenter {
    private  IloginView iloginView;
    private  LoginModle loginModle;
    public  LoginPresenter(IloginView iloginView){
        loginModle = new LoginModle();
        this.iloginView=iloginView;
    }
     public  void login(HashMap<String,String> params){
         String mobile="13522578752";
         String password="222222";
         if (!ValidatorUtils.isMobile(mobile)){
             if (iloginView!=null){
                 iloginView.mobileErrorr("请输入合法手机号");
             }
             return;
         }
         if (loginModle!=null){
             loginModle.login(params, new RequestCallback() {
                 @Override
                 public void failure(String msg) {
                     if (iloginView!=null){
                         iloginView.failure(msg);
                     }
                 }

                 @Override
                 public void successMsg(String msg) {
                     if (iloginView!=null){
                         iloginView.successMsg(msg);
                     }
                 }

                 @Override
                 public void success(UserBean userBean) {
                     if (iloginView!=null){
                         iloginView.success(userBean);
                     }
                 }
             });
         }

     }
}
