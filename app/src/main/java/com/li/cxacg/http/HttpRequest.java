package com.li.cxacg.http;


import com.li.cxacg.exception.ApiException;

/**
 * 网络请求监听（成功/失败）
 */

public interface HttpRequest<T> {
    void onSuccess(T t);
    void onFail(ApiException msg);
}
