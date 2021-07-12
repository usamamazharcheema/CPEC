package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/19/2017.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Numberpricelist {

    @SerializedName("numberprice_response")
    @Expose
    private List<NumberpriceResponse> numberpriceResponse = null;

    public List<NumberpriceResponse> getNumberpriceResponse() {
        return numberpriceResponse;
    }

    public void setNumberpriceResponse(List<NumberpriceResponse> numberpriceResponse) {
        this.numberpriceResponse = numberpriceResponse;
    }

}