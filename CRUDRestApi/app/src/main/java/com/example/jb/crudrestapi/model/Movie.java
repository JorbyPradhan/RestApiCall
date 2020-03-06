package com.example.jb.crudrestapi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("movie_name")
    @Expose
    private String movieName;
    @SerializedName("main_lead")
    @Expose
    private String mainLead;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("budget")
    @Expose
    private String budget;
    @SerializedName("dbo")
    @Expose
    private String dbo;
    @SerializedName("obo")
    @Expose
    private String obo;
    @SerializedName("wbo")
    @Expose
    private String wbo;
    @SerializedName("des")
    @Expose
    private String des;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("tit")
    @Expose
    private String tit;
    @SerializedName("o_name")
    @Expose
    private String oName;

    public Movie() {
    }

    public Movie(String movieName, String mainLead, String director, String budget, String dbo, String obo, String wbo, String des, String rank, String tit, String oName) {
        this.movieName = movieName;
        this.mainLead = mainLead;
        this.director = director;
        this.budget = budget;
        this.dbo = dbo;
        this.obo = obo;
        this.wbo = wbo;
        this.des = des;
        this.rank = rank;
        this.tit = tit;
        this.oName = oName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMainLead() {
        return mainLead;
    }

    public void setMainLead(String mainLead) {
        this.mainLead = mainLead;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDbo() {
        return dbo;
    }

    public void setDbo(String dbo) {
        this.dbo = dbo;
    }

    public String getObo() {
        return obo;
    }

    public void setObo(String obo) {
        this.obo = obo;
    }

    public String getWbo() {
        return wbo;
    }

    public void setWbo(String wbo) {
        this.wbo = wbo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }
}

