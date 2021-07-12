package com.example.fm.cpec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumberphaseResponse {

    @SerializedName("phase")
    @Expose
    private String phase;

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

}