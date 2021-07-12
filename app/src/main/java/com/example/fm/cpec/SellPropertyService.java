package com.example.fm.cpec;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Usama Cheema on 12/8/2017.
 */

public interface SellPropertyService {
    @FormUrlEncoded
    @POST("insertaddproperty.php")
    Call<MSG> insertData(@Field("name") String name, @Field("phonenumber") String phone, @Field("Area") String Area, @Field("Plot") String plot, @Field("Sqr_Yard") String Sqr_Yard,@Field("price") String price,@Field("nearlocation") String nearlocation,@Field("phase") String phase, @Field("additionalinfo") String additionalinfo, @Field("title") String title, @Field("email") String email);

}
