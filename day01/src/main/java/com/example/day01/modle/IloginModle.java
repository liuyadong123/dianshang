package com.example.day01.modle;

import com.example.day01.net.RequestCallback;

import java.util.HashMap;

public interface IloginModle {
    void login(HashMap<String,String> params, RequestCallback callback);
}
