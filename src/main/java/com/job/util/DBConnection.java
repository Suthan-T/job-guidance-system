package com.job.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

        private static final String url="jdbc:postgresql://localhost:5432/job_guidance_system";
        private static final String username="postgres";
        private static final String password="enter your password";

        public static Connection getConnection(){
            try{
                return DriverManager.getConnection(url,username,password);
            }
            catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }

}
