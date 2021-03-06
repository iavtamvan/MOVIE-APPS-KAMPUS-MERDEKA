package com.iavariav.moviedb.teknik.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TeknikRootModel{

    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public void setData(List<DataItem> data){
        this.data = data;
    }

    public List<DataItem> getData(){
        return data;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}