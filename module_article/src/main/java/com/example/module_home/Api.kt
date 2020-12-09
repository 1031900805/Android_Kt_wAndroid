package com.example.module_home

import com.example.common_base.base.BaseResponse
import com.example.common_base.base.BaseResult
import com.example.module_home.firstpage.bean.Article
import com.example.module_home.firstpage.bean.ArticleResponse
import com.example.module_home.firstpage.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchResultResponse
import retrofit2.http.*

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
interface Api {
    @GET("article/list/{page}/json")
    suspend fun getArticles(@Path("page") page: Int): BaseResponse<ArticleResponse>

    @GET("article/top/json")
    suspend fun getTopArticles(): BaseResponse<MutableList<Article>>

    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<MutableList<BannerBean>>

    @GET("hotkey/json")
    suspend fun getHotKey(): BaseResponse<MutableList<HotKeyBean>>

    @POST("article/query/{page}/json")
    @FormUrlEncoded
    suspend fun searchByKey(@Path("page") page: Int, @Field("k") keyword: String): BaseResponse<SearchResultResponse>
}