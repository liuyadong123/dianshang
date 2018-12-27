package com.example.day02.presenter.userpresenter;

import com.example.day02.modle.user.RegModle;
import com.example.day02.utils.ValidatorUtils;
import com.example.day02.view.user.IRegView;

import java.util.HashMap;

public class RegPresenter {
    private RegModle regModle;
    private IRegView iRegView;
    public  RegPresenter(IRegView iRegView){
        regModle=new RegModle();
        this.iRegView=iRegView;
    }
    public  void register(HashMap<String,String> params){
        String mobile=params.get("mobile");
        if (!ValidatorUtils.isMobile(mobile)){
            if (iRegView!=null){
                iRegView.mobileError("手机号不合法");
            }
            return;

        }
        if (regModle!=null){
            regModle.reg(params);
            regModle.setmRegcallback(new RegModle.RegCallback() {
                @Override
                public void onFailure(String msg) {
                    if (iRegView!=null){
                        iRegView.failure(msg);
                    }
                }

                @Override
                public void onRespones(String result) {
                     if (iRegView!=null){
                         iRegView.success(result);
                     }
                }
            });
        }
    }

    public void destroy() {

        if (iRegView!=null){
            iRegView = null;
        }
    }
}
