package com.example.module_usercenter.api;

import com.example.common_base.base.data.BaseResponse;
import com.example.module_usercenter.bean.LoginResult;
import com.example.module_usercenter.bean.RegisterResult;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 */
public interface UserCenterApiService {

    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResult>> login(@Field("username") String name,
                                                @Field("password") String pwd);

    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<RegisterResult>> register(@Field("username") String name,
                                                      @Field("password") String pwd,
                                                      @Field("repassword") String repwd);

}
