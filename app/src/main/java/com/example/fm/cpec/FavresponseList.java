package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/18/2017.
 */
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class FavresponseList {

    @SerializedName("favresponse")
    @Expose
    private List<Favresponse> favresponse = null;

    public List<Favresponse> getFavresponse() {
        return favresponse;
    }

    public void setFavresponse(List<Favresponse> favresponse) {
        this.favresponse = favresponse;
    }

}