package com.ims.model;

public class SubCategoryDetails {
    private int sbid;
    private String sbname;
    private String description;

    public int getSbid() {
        return sbid;
    }

    public void setSbid(int sbid) {
        this.sbid = sbid;
    }

    public String getSbname() {
        return sbname;
    }

    public void setSbname(String sbname) {
        this.sbname = sbname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubCategoryDetails(String sbname, String description) {
        this.sbname = sbname;
        this.description = description;
    }

    public SubCategoryDetails(int sbid, String sbname, String description) {
        this.sbid = sbid;
        this.sbname = sbname;
        this.description = description;
    }

    public SubCategoryDetails() {
       super();
    }
}
