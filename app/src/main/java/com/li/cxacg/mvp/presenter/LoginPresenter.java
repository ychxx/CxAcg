package com.li.cxacg.mvp.presenter;

import com.li.cxacg.bean.LoginBean;
import com.li.cxacg.bean.UpdateBean;
import com.li.cxacg.exception.ApiException;
import com.li.cxacg.http.BaseObserver;
import com.li.cxacg.mvp.BasePresenter;
import com.li.cxacg.mvp.contact.LoginContact;
import com.li.cxacg.mvp.model.LoginModel;

/**
 * 登录Presenter
 */

public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {
    @Override
    public void login(String passWord, String userName, String imei) {
        new LoginModel()
                .login(passWord, userName, imei)
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        getIView().onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onLoginFail();
                    }
                });
    }

    @Override
    public void getVersion(String packageName, String updateVersionCode) {
        new LoginModel()
                .getVersion(packageName, updateVersionCode)
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<UpdateBean>() {
                    @Override
                    public void onSuccess(UpdateBean loginBean) {
                        getIView().onGetVersionSuccess(loginBean);
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onGetVersionFail();
                    }
                });
    }
}
