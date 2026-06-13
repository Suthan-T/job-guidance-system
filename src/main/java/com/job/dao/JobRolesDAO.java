package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.job.model.JobRoles;
import com.job.util.DBConnection;

public class JobRolesDAO {

    public void addJobRoles(JobRoles jobroles){
        //Companies companies=new Companies();
        String sql="INSERT INTO job_roles(company_id,title,description,industry,location) VALUES(?,?,?,?,?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,jobroles.getCid());
            ps.setString(2,jobroles.getTitle());
            ps.setString(3,jobroles.getDescription());
            ps.setString(4,jobroles.getIndustry());
            ps.setString(5,jobroles.getLocation());

            ps.executeUpdate();

            System.out.println(jobroles.getCid()+" added Job Roles");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
