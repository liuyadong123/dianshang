package com.example.day02.modle;

import com.example.day02.net.RequestCallback;

import java.util.HashMap;

public interface IloginModle {
    void login(HashMap<String,String> params, RequestCallback callback);
}
