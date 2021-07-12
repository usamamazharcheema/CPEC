package com.example.fm.cpec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumberpriceResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("areaname")
    @Expose
    private String areaname;
    @SerializedName("phase")
    @Expose
    private String phase;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("date")
    @Expose
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}