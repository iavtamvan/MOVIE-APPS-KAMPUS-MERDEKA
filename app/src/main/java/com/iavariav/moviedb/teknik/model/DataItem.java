package com.iavariav.moviedb.teknik.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

    @SerializedName("nama_kat")
    private String namaKat;

    @SerializedName("id")
    private String id;

    @SerializedName("childs")
    private List<ChildsItem> childs;

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

    public void setChilds(List<ChildsItem> childs){
        this.childs = childs;
    }

    public List<ChildsItem> getChilds(){
        return childs;
    }
}