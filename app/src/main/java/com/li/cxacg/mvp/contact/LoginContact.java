package com.li.cxacg.mvp.contact;


import com.li.cxacg.bean.LoginBean;
import com.li.cxacg.bean.UpdateBean;
import com.li.cxacg.mvp.IView;

/**
 * Created by administration on 2017/9/4.
 */

public class LoginContact {
    public interface View extends IView {
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFail();
        void onGetVersionSuccess(UpdateBean updateBean);
        void onGetVersionFail();
    }

    public interface Presenter {
        void login(String passWord, String userName, String imei);
        void getVersion(String packageName, String updateVersionCode);
    }
}
