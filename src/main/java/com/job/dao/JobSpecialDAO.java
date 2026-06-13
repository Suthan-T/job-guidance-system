package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.job.model.JobSpecialization;
import com.job.util.DBConnection;

public class JobSpecialDAO{
    public void addJobSpecial(JobSpecialization jobspecial){

        String sql="INSERT INTO job_specifications(job_id,experience_level,responsibilities,salary_range) VALUES(?,?,?,?)";

        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,jobspecial.getJid());
            ps.setString(2, jobspecial.getExperience());
            ps.setString(3, jobspecial.getResponsibilities());
            ps.setString(4, jobspecial.getSalary());

            ps.executeUpdate();

            System.out.print("Job Specifications Added");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
