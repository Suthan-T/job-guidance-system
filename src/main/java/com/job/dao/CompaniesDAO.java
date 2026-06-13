package com.job.dao;

import com.job.model.Companies;
import com.job.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompaniesDAO{
    public void addCompanies(Companies companies){

        String sql="INSERT INTO companies(name, description, website, headquarters) VALUES(?,?,?,?)";

        try{
            Connection con = DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,companies.getName());
            ps.setString(2,companies.getDescription());
            ps.setString(3,companies.getWebsite());
            ps.setString(4,companies.getHeadquarters());

            ps.executeUpdate();

            System.out.println("Inserted Successfully");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}