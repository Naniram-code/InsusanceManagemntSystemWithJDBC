package com.ims.model;

public class CategoryDetail {
    //for retrieve dCategory details
    public CategoryDetail(int cid,String cname, String description) {
        this.cid = cid;
        this.cname = cname;
        this.description = description;
    }
      //for create or add new  Category
    public CategoryDetail(String cname,  String description) {
        this.cname = cname;
        this.description = description;
    }

    private String cname;
    private int cid;
    private String description;

    public String getcname() {
        return cname;
    }

    public void setcname(String cname) {
        this.cname = cname;
    }

    public int getcid() {
        return cid;
    }

    public void setcid(int cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
