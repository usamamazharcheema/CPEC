package com.example.fm.cpec;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fm on 12/7/2017.
 */

public interface SignupService {

    @FormUrlEncoded
    @POST("Industrial/login/signup.php")
    Call<MSG> insertData(@Field("name") String name, @Field("email") String email , @Field("location") String location, @Field("phonenumber") String phonenumber, @Field("password") String password);
    @FormUrlEncoded
    @POST("Industrial/login/signup.php")
    Call<MSG> GmailData(@Field("name") String gmail_name, @Field("email") String gmail_email );
    @FormUrlEncoded
    @POST("Industrial/login/signup.php")
    Call<MSG> FbData(@Field("name") String gmail_name, @Field("email") String gmail_email );

    @FormUrlEncoded
    @POST("Industrial/login/favourite.php")
    Call<MSG> insertFavData(@Field("favid") String myid);

}