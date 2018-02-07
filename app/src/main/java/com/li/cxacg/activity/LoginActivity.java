package com.li.cxacg.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.li.cxacg.R;
import com.li.cxacg.base.BaseActivity;
import com.li.cxacg.bean.LoginBean;
import com.li.cxacg.bean.UpdateBean;
import com.li.cxacg.mvp.contact.LoginContact;
import com.li.cxacg.mvp.presenter.LoginPresenter;
import com.orhanobut.logger.Logger;

import butterknife.OnClick;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContact.View {

    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
//        mPresenter.login("123456","17301370712","123");
    }


    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Logger.e("登录成功"+loginBean.toString());
    }

    @Override
    public void onLoginFail() {
        Logger.e("登录失败");
    }

    @Override
    public void onGetVersionSuccess(UpdateBean updateBean) {
        Logger.e("获取版本信息成功"+updateBean.toString());
    }

    @Override
    public void onGetVersionFail() {
        Logger.e("获取版本信息失败");
    }

    @OnClick({R.id.login})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.login:
//                mPresenter.login("123456","17301370712","123");
                Log.e("Log","点击");
                Logger.e("点击1");
                mPresenter.getVersion("com.hc.android.mobileattendance","1");
                break;
        }
    }
}
