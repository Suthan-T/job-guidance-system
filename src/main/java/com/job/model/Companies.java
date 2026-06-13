package com.job.model;

public class Companies {
    
    private int id;
    private String name;
    private String description;
    private String website;
    private String headquarters;

    public Companies(){}

    public Companies(String name, String description, String website, String headquarters){
        this.name=name;
        this.description=description;
        this.website=website;
        this.headquarters=headquarters;
    }
        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id =id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }

        public String getDescription(){
            return description;
        }

        public void setDescription(String description){
            this.description = description;
        }

        public String getWebsite(){
            return website;
        }

        public void setWebsite(String website){
            this.website=website;
        }

        public String getHeadquarters(){
            return headquarters;
        }

        public void setHeadquarters(String headquarters){
            this.headquarters=headquarters;
        }


    
}
