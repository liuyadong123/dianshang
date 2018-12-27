package com.example.day03.apdate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.day03.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class MyBase extends BaseAdapter {
    private List<UserBean.DataBean> list;
    private Context context;

    public MyBase(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position==0?0:1;
    }

    public  void setData(List<UserBean.DataBean> list){
        if (list!=null){
            this.list=list;
            notifyDataSetChanged();
        }
    }
    public  void addData(List<UserBean.DataBean> list){
        if (list!=null){
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position)==0){



        }else {


        }
        return convertView;
    }
}
