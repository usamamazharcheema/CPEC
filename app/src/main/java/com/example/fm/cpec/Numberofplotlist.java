package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/19/2017.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Numberofplotlist {

    @SerializedName("numberplot_response")
    @Expose
    private List<NumberplotResponse> numberplotResponse = null;

    public List<NumberplotResponse> getNumberplotResponse() {
        return numberplotResponse;
    }

    public void setNumberplotResponse(List<NumberplotResponse> numberplotResponse) {
        this.numberplotResponse = numberplotResponse;
    }

}