package com.example.fm.cpec;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Usama Cheema on 12/12/2017.
 */

public interface NumberOfRowsMain {
    @FormUrlEncoded
    @POST("hometable/selectnumberofrowsinhome.php")
    Call<Numberrowsmain> numberofrowsmain(@Field("rows") String rows);

    @FormUrlEncoded
    @POST("SearchFilter/numberofrows.php")
    Call<Numberrowsmain> numberofrowssearchfilter(@Field("plot") String plot);
    @FormUrlEncoded
    @POST("hometable/sold.php")
    Call<MainResponselist> numberrworesponsesold(@Field("rows") int rows);

    @FormUrlEncoded
    @POST("hometable/selecthometable.php")
    Call<MainResponselist> numberrworesponse(@Field("rows") int rows);

    @FormUrlEncoded
    @POST("hometable/openmain.php")
    Call<MainResponselist> openmainresponse(@Field("id") int id);
    @FormUrlEncoded
    @POST("SearchFilter/catogoryfiltermain.php")
    Call<MainResponselist> searchcityfilter(@Field("id") int id, @Field("City") String City);

    @FormUrlEncoded
    @POST("SearchFilter/searchfiltermainfirst.php")
    Call<MainResponselist> searchfilter(@Field("id") int id, @Field("plot") String plot);
    @FormUrlEncoded
    @POST("SearchFilter/searchfilterresictfirst.php")
    Call<MainResponselist> searchresifilter(@Field("id") int id, @Field("plot") String plot,@Field("areaname") String areaname,@Field("phase") String phase);
    @FormUrlEncoded
    @POST("SearchFilter/searchgwdcat.php")
    Call<MainResponselist> searchrgwdfilter(@Field("id") int id, @Field("plot") String plot,@Field("areaname") String areaname);

    @FormUrlEncoded
    @POST("SearchFilter/getdatabyprice.php")
    Call<MainResponselist> searchfilterresposeasc(@Field("plot") String plot, @Field("rownnumber") int rownnumber, @Field("searchkey") String searchkey);
    @FormUrlEncoded
    @POST("SearchFilter/getcatdatabyprice.php")
    Call<MainResponselist> searchcatfilterresposeasc(@Field("plot") String plot, @Field("rownnumber") int rownnumber, @Field("searchkey") String searchkey, @Field("areaname") String areaname);
    @FormUrlEncoded
    @POST("SearchFilter/getdatabypricedese.php")
    Call<MainResponselist> searchfilterresposedec(@Field("plot") String plot, @Field("rownnumber") int rownnumber, @Field("searchkey") String searchkey);
    @FormUrlEncoded
    @POST("SearchFilter/getcatdatabypricedesc.php")
    Call<MainResponselist> searchcatfilterresposedec(@Field("plot") String plot, @Field("rownnumber") int rownnumber, @Field("searchkey") String searchkey, @Field("areaname") String areaname);
    @FormUrlEncoded
    @POST("SearchFilter/searchfilteropen.php")
    Call<MainResponselist> searchfilteropen(@Field("plot") String plot, @Field("minrice") int minrice, @Field("maxprice") int maxprice, @Field("minarea") int minarea, @Field("maxarea") int maxarea, @Field("rownumber") int rownumber);
    @FormUrlEncoded
    @POST("favorite/insertfav.php")
    Call<MSG> insertfav(@Field("email") String email, @Field("favid") int favid);
    @GET
    Call<MainResponselist> favourite(@Url String url);



    @FormUrlEncoded
    @POST("favorite/selectfav.php")
    Call<MainResponselist> favlistget(@Field("email") String email,@Field("rownumber") int rownumber);
    @FormUrlEncoded
    @POST("myproperty/getmyproperty.php")
    Call<MainResponselist> getmyproperty(@Field("email") String email,@Field("rownumber") int rownumber);

    @FormUrlEncoded
    @POST("trending/selecttrending.php")
    Call<Numberofplotlist> getplotnum(@Field("plot") String plot);

    @FormUrlEncoded
    @POST("trending/selectphase.php")
    Call<NUmberphaseresponcelist> getphasenum(@Field("areaname") String areaname,@Field("plot") String plot);
    @FormUrlEncoded
    @POST("trending/selectprice.php")
    Call<Numberpricelist> getpricenum(@Field("plot") String plot);

    @FormUrlEncoded
    @POST("hometable/selectlast5.php")
    Call<MainResponselist> getlastprice(@Field("plot") String plot);

    @FormUrlEncoded
    @POST("trending/slectpricenew.php")
    Call<Numberpricelist> getpricenumnew(@Field("areaname") String areaname,@Field("plot") String plot,@Field("phase") String phase);

}
