package com.example.fm.cpec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Favresponse {

@SerializedName("id")
@Expose
private String id;
@SerializedName("favid")
@Expose
private String favid;
@SerializedName("email")
@Expose
private String email;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getFavid() {
return favid;
}

public void setFavid(String favid) {
this.favid = favid;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

}