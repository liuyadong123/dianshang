package com.example.day01.net;

import com.example.day01.bean.UserBean;

public interface RequestCallback {
  void failure(String msg);
  void successMsg(String msg);
  void success(UserBean userBean);
}
