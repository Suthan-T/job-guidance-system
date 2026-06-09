package com.job.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args){
        String url="jdbc:postgresql://localhost:5432/job_guidance_system";
        String username="postgres";
        String password="Enter_your_password";
       // String sql="SELECT * FROM job_roles";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Database Connected Successfully!");
        }
        
        catch(Exception e){
            System.out.print("Connection Failed");
            e.printStackTrace();
        }
    }
}
