package com.li.cxacg.http;


import com.li.cxacg.bean.LoginBean;
import com.li.cxacg.bean.UpdateBean;
import com.li.cxacg.url.UrlHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by GaoSheng on 2016/9/13.
 * 网络请求的接口都在这里
 */

public interface ApiService {
    //获取banner
    //String url = "";

    @FormUrlEncoded
    @POST(UrlHelper.API+"DataService.ashx?action=login")
    Observable<NetResponse<LoginBean>> login(@Field("password") String passWord, @Field("account") String userName, @Field("imei") String imei);

    @FormUrlEncoded
    @POST("Services/DataService.ashx?action=getAppUpdate")
    Observable<NetResponse<UpdateBean>> getVersion(@Field("packageName") String packageName, @Field("updateVersionCode") String updateVersionCode);
}
