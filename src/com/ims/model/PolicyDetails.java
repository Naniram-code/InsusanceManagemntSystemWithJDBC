package com.pms.model;

public class PolicyDetails {
    private int pid;
    private String pName;
    private String category;
    private String subCategory;
    private String description;

    public String getSubCategor() {
        return subCategory;
    }

    public void setSubCategor(String subCategor) {
        this.subCategory = subCategor;
    }

    private int sumAssured;
    private int premium;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(int sumAssured) {
        this.sumAssured = sumAssured;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public PolicyDetails(int pid, String pName, String category, String subCategory, int sumAssured, int premium,String description) {
        this.pid = pid;
        this.pName = pName;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.sumAssured = sumAssured;
        this.premium = premium;
    }

    public PolicyDetails(String pName, String category, String subCategory,  int sumAssured, int premium,String description) {
        this.pName = pName;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.sumAssured = sumAssured;
        this.premium = premium;
    }
}





