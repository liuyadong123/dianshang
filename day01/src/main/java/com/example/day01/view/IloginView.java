package com.example.day01.view;

import com.example.day01.bean.UserBean;

public interface IloginView {
    void mobileErrorr(String msg);
    void pwdErrorr(String msg);
    void failure(String msg);
    void success(UserBean userBean);
    void successMsg(String msg);
}
