package com.example.fm.cpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fm on 12/7/2017.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("Industrial/login/login.php")
    Call<MSG> userLogIn(@Field("email") String email,
                        @Field("password") String password);
    @FormUrlEncoded
    @POST("Industrial/login/gmaillogin.php")
    Call<MSG> userGmailLogIn(@Field("email") String email,
                        @Field("name") String name);
    @FormUrlEncoded
    @POST("Industrial/login/gmaillogin.php")
    Call<MSG> userFbLogIn(@Field("email") String email,
                             @Field("name") String name);
}
