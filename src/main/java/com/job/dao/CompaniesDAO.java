package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.job.model.Companies;
import com.job.util.DBConnection;

public class CompaniesDAO{
    //To add/insert companies record
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

    //To read all companies record
    public void getAllCompany(){
        String sql="SELECT * FROM companies";
        try (
            Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){
            System.out.println("|ID |Name   |Description|Website          |Headquarters|");
            System.out.println("|------------------------------------------------------|");

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String desc=rs.getString("description");
                String web=rs.getString("website");
                String head=rs.getString("headquarters");

                System.out.println("| "+id+" |"+name+" |"+desc+" |"+web+" |"+head+" |");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //To read companies by thier ID
    public void getByID(int sid){
        String sql="SELECT * FROM companies WHERE id=?";

        try{Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
               ps.setInt(1,sid);
               try(ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        int id=rs.getInt("id");
                        String name=rs.getString("name");
                        String desc=rs.getString("description");
                        String web=rs.getString("website");
                        String head=rs.getString("headquarters");

                        System.out.println("Record Found!");
                        System.out.println("| "+id+" |"+name+" |"+desc+" |"+web+" |"+head+" |");
                    }
                    else{
                        System.out.println("No records found!! for ID:"+sid);
                    }
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }


    //To update comapnies description
    public void updateDes(Companies companies){
        String sql="UPDATE companies SET description=? WHERE name=?";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,companies.getDescription());
            ps.setString(2,companies.getName());
            ps.executeUpdate();

            System.out.print("Company Description Updated");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //To delete companies by ID
    public void delete(int cid){
        String sql="DELETE FROM companies WHERE id=?";
        try (
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1, cid);
            int affected=ps.executeUpdate();

            if(affected>0){
                System.out.println("Success!! Deleted Records:"+cid);
            }
            else{
                System.out.println("No records matched provided ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}