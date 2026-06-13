package com.job.model;

public class JobRoles {
    
    private int id;
    private int c_id;
    private String title;
    private String description;
    private String industry;
    private String location;

    public JobRoles(){}
    
    public JobRoles(int c_id, String title, String description, String industry, String location){
        this.c_id=c_id;
        this.title=title;
        this.description=description;
        this.industry=industry;
        this.location=location;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getCid(){
        return c_id;
    }
    public void setCid(int c_id){
        this.c_id=c_id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getIndustry(){
        return industry;
    }
    public void setIndustry(String industry){
        this.industry=industry;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }

}
