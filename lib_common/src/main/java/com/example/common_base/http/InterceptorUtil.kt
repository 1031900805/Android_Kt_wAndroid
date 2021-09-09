package com.example.common_base.http;

import android.text.TextUtils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Description:头部 和 日志拦截器
 * @author zhang.wenqiang
 */
public class InterceptorUtil {

    /**
     * 头部拦截器
     * @return
     */
    public static Interceptor headerInterceptor() {
        return chain -> {
            Request.Builder builder = chain.request().newBuilder();
            builder.addHeader("X-APP-Agent", "corp_zx_app")
                    .addHeader("X-OS", "Android")
                    .addHeader("X-APP-ID", "20181130000009")
                    .addHeader("X-DEVICE-TYPE", "USERNAME")
                    .addHeader("appId", "281")
                    .addHeader("businessType", "610001");

            String token = "";
            if (!TextUtils.isEmpty(token)) {
                builder.addHeader("Access-Token", token);
            }

            Request build = builder.build();
            return chain.proceed(build);
        };
    }

    public static Interceptor logInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
