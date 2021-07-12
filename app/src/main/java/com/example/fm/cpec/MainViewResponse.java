package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainViewResponse{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("selling")
    @Expose
    private String selling;

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    @SerializedName("Area")
    @Expose
    private String cityarea;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityarea() {
        return cityarea;
    }

    public void setCityarea(String cityarea) {
        this.cityarea = cityarea;
    }

    @SerializedName("City")

    @Expose
    private String city;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("areaname")
    @Expose
    private String areaname;
    @SerializedName("sqr_yard")
    @Expose
    private String sqrYard;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("email")
    @Expose
    private String email;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSqrYard() {
        return sqrYard;
    }

    public void setSqrYard(String sqrYard) {
        this.sqrYard = sqrYard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}