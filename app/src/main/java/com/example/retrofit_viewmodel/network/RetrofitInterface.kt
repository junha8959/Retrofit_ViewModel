package org.bumblebeecrew.blossom.network

import com.skydoves.sandwich.ApiResponse
import okhttp3.RequestBody
import org.bumblebeecrew.blossom.Model.*
import org.bumblebeecrew.blossom.network.request.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface RetrofitInterface {
    // DataClass > 요청 GET에 대한 응답데이터를 받아서 DTO 객체화할 클래스 타입 지정
    // getId > 메소드 명. 자유롭게 설정 가능, 통신에 영향x
    // @Path("post") String post > 매개변수. 매개변수 post가 @Path("post")를 보고 @GET 내부 {post}에 대입

    @GET("confirm")
    suspend fun confirm(
    ): ApiResponse<DataClassConfirm>

    @POST("auth/login")
    suspend fun authLogin(@Body requestLogin: RequestLogin?
    ): ApiResponse<Login>

    @POST("auth/email")
    fun authEmail(@Body requestEmail: RequestEmail?
    ): Call<Login>

    @PUT("auth/email")
    fun authEmailCertification( @Body requestCertification: RequestCertification?
    ): Call<Login>

    @GET("account")
    fun accountIdCheck( @Query("id") id: String?, @Query("type") type: String?
    ): Call<Login>

    @POST("account/device")
    fun accountDevice( @Body requestDevice: RequestDevice?
    ): Call<Login>

    @PUT("account/device/{code}")
    fun accountDeviceModify( @Body requestDevice: RequestDevice?, @Path("code") code: String?
    ): Call<Login>

    @GET("account/devices")
    fun accountDevices( @Query("id") id: String?, @Query("type") type: String?
    ): Call<Devices>

    @POST("account")
    fun account(@Body requestAccount: RequestAccount?): Call<Login>

    @GET("account/guilds")
    fun guilds(): Call<Guilds>

    @POST("account/guild")
    fun authGuild(): Call<Guild>

    @PUT("account/guild")
    fun putGuild(@Body requestGuild: RequestGuild?): Call<Guilds>


    /* @GET("guild/{id}/channels")
     fun getId(@Header("OsType") contentType: String, @Path("id") id: String?): Call<BlossomDataClass>

     @GET("guild/{id}/channels")
     fun getGuild(@HeaderMap headers: Map<String, String>, @Path("id") id: String, @Query("type") type: String?): Call<BlossomDataClass>

     @GET("guild/{id}/channels")
     fun getGuildType(@HeaderMap headers: Map<String, String>, @Path("id") id: String, @Query("type") type: String?): Call<BlossomDataClass>*/
}