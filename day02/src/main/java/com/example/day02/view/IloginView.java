package com.example.day02.view;

import com.example.day02.bean.UserBean;

public interface IloginView {
    void mobileError(String msg);
    void pwdError(String msg);
    void success(UserBean userBean);
    void successMsg(String msg);
    void failure(String msg);
}
