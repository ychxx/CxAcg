package com.li.cxacg.http;

import com.li.cxacg.exception.ErrorType;
import com.li.cxacg.exception.ExceptionEngine;
import com.li.cxacg.utils.NetworkUtil;
import com.li.cxacg.utils.ToastUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018-01-09.
 */

public abstract class BaseObserver<T> implements Observer<T>, HttpRequest<T> {
    private Disposable disposable;
    //当订阅后，会首先调用这个方法，其实就相当于onStart()，
    //传入的Disposable d参数可以用于取消订阅
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        if (!NetworkUtil.isNetworkAvailable()) {
            Logger.e("网络不可用");
            disposable.dispose();
        }
    }
    @Override
    public void onNext(@NonNull T response) {
        //防止闪退问题
        try {
            onSuccess(response);
        }catch (NullPointerException e){
            e.printStackTrace();
            ToastUtil.show("网络异常！错误码:"+ ErrorType.DATE_NULL);
        }catch (Exception e){
            e.printStackTrace();
            ToastUtil.show("网络异常！错误码:"+ ErrorType.UNKNOWN);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onError(ExceptionEngine.handleException(e));
    }

    @Override
    public void onComplete() {
    }
}
