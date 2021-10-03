package com.iavariav.moviedb.teknik.model;

import com.google.gson.annotations.SerializedName;

public class ChildsItem{

    @SerializedName("parent")
    private String parent;

    @SerializedName("nama_kat")
    private String namaKat;

    @SerializedName("id")
    private String id;

    public void setParent(String parent){
        this.parent = parent;
    }

    public String getParent(){
        return parent;
    }

    public void setNamaKat(String namaKat){
        this.namaKat = namaKat;
    }

    public String getNamaKat(){
        return namaKat;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}