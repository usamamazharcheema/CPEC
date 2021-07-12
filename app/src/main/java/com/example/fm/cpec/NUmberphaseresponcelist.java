package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/19/2017.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NUmberphaseresponcelist  {

    @SerializedName("numberphase_response")
    @Expose
    private List<NumberphaseResponse> numberphaseResponse = null;

    public List<NumberphaseResponse> getNumberphaseResponse() {
        return numberphaseResponse;
    }

    public void setNumberphaseResponse(List<NumberphaseResponse> numberphaseResponse) {
        this.numberphaseResponse = numberphaseResponse;
    }

}