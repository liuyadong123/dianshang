package com.example.day02.net;

import com.example.day02.bean.UserBean;

public interface RequestCallback {
    void success(UserBean userBean);
    void failure(String msg);
    void successMsg(String msg);
}
