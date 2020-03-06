package com.example.jb.crudrestapi.model;

import java.util.List;

public class Post {

    private int page;
    private int totalResults;
    private int totalPages;
    private List<Result> results = null;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
/*public class Post {
    @SerializedName("o_id")
    private int oId;
    private String name;
    private String website;
    private String address;
    private String email;
    private String phone;
    private String password;
    private Object departments;

    public Post(int oId, String name, String website, String address, String email, String phone, String password, Object departments) {
        this.oId = oId;
        this.name = name;
        this.website = website;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.departments = departments;
    }

    public int getOId() {
        return oId;
    }


    public void setOId(int oId) {
        this.oId = oId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getDepartments() {
        return departments;
    }

    public void setDepartments(Object departments) {
        this.departments = departments;
    }

}*/
/*

public class Post {

    private int userId;
    private int id;
    private String title;
    //@SerializedName("body") so String body changes any kind of name like String bo;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
*/
