package com.job.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

        private static final String url="jdbc:postgresql://localhost:5432/job_guidance_system";
        private static final String username="postgres";
        private static final String password="enteryour password";

        public static Connection getConnection(){
            try{
            	try {
            	    Class.forName("org.postgresql.Driver"); // Force registration
            	} catch (ClassNotFoundException e) {
            	    e.printStackTrace();
            	}

                return DriverManager.getConnection(url,username,password);
            }
            catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }

}
