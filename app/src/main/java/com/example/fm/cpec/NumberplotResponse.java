package com.example.fm.cpec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumberplotResponse {

    @SerializedName("plot")
    @Expose
    private String plot;

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

}