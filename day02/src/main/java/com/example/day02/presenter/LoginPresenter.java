package com.example.day02.presenter;

import com.example.day02.bean.UserBean;
import com.example.day02.modle.LoginModle;
import com.example.day02.net.RequestCallback;
import com.example.day02.utils.ValidatorUtils;
import com.example.day02.view.IloginView;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenter {
     private LoginModle loginModle;
     private IloginView iloginView;
     public  LoginPresenter(IloginView iloginView){
        loginModle=new LoginModle();
        this.iloginView=iloginView;
     }
     public  void login(HashMap<String,String> params){

         String mobile="18612991023";
         String password="222222";
         if (!ValidatorUtils.isMobile(mobile)){
              if (iloginView!=null){
                  iloginView.mobileError("请输入合法的手机号");
              }
         }
         if (loginModle!=null){
             loginModle.login(params, new RequestCallback() {
                 @Override
                 public void success(UserBean userBean) {
                     if (iloginView!=null){
                         iloginView.success(userBean);
                     }
                 }

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
             });
         }

     }
}
