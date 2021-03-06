package com.andriawan.divergent_mobile_apps.data.network

import com.andriawan.divergent_mobile_apps.models.auth.response.LoginResponse
import com.andriawan.divergent_mobile_apps.models.auth.PostLogin
import com.andriawan.divergent_mobile_apps.models.auth.PostRegister
import com.andriawan.divergent_mobile_apps.models.articles.ArticleResponse
import com.andriawan.divergent_mobile_apps.models.diagnose.PostDiagnose
import com.andriawan.divergent_mobile_apps.models.diagnose.response.DiagnoseResponse
import com.andriawan.divergent_mobile_apps.models.history_diagnose.HistoryDiagnoseResponse
import com.andriawan.divergent_mobile_apps.models.profile.PostProfile
import com.andriawan.divergent_mobile_apps.models.profile.response.UpdateProfileResponse
import com.andriawan.divergent_mobile_apps.models.symptoms.SymptomsResponse
import retrofit2.Response
import retrofit2.http.*

interface DivergentApi {
    @POST("login")
    suspend fun login(@Body postLogin: PostLogin): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body postRegister: PostRegister): Response<LoginResponse>

    @GET("articles")
    suspend fun getArticles(@QueryMap params: Map<String, String>): Response<ArticleResponse>

    @PUT("profile/update")
    suspend fun updateProfile(@Body postProfile: PostProfile): Response<UpdateProfileResponse>

    @GET("symptoms")
    suspend fun getSymptoms(@QueryMap params: Map<String, String>): Response<SymptomsResponse>

    @POST("diagnose")
    suspend fun diagnose(@Body postDiagnose: PostDiagnose): Response<DiagnoseResponse>

    @GET("diagnose/histories")
    suspend fun diagnoseHistories(@Query("sort") sort: String): Response<HistoryDiagnoseResponse>
}