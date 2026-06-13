package com.job.model;

public class JobSpecialization {
    
    private int id;
    private int j_id;
    private String experience;
    private String responsibilities;
    private String salary;

    public JobSpecialization(){};

    public JobSpecialization(int j_id, String experience, String responsibilities, String salary){
        this.j_id=j_id;
        this.experience=experience;
        this.responsibilities=responsibilities;
        this.salary=salary;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getJid(){
        return j_id;
    }
    public void setJid(int j_id){
        this.j_id=j_id;
    }
    public String getExperience(){
        return experience;
    }
    public void setExperience(String experience){
        this.experience=experience;
    }
    public String getResponsibilities(){
        return responsibilities;
    }
    public void setResponsibilities(String responsibilities){
        this.responsibilities=responsibilities;
    }
    public String getSalary(){
        return salary;
    }
    public void setSalary(String salary){
        this.salary=salary;
    }
}