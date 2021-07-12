package com.example.fm.cpec;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Usama Cheema on 12/12/2017.
 */

public class MainResponselist {
    @SerializedName("server_response")
    private List<MainViewResponse> Results;

    public List<MainViewResponse> getResults() {
        return Results;
    }

    public void setResults(List<MainViewResponse> results) {
        Results = results;
    }
}

