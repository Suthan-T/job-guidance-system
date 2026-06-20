package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.job.model.JobRoles;
import com.job.util.DBConnection;

public class JobRolesDAO {

    //To Add/Insert Job Roles records
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

    //To read all Job Roles Records
    public void getAllJobRoles(){
        String sql="SELECT * FROM job_roles";

        try (
            Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){
            System.out.println("|ID|C_ID|Title|Description|Industry|Location|");
            System.out.println("-------------------------------------------------------");

            while(rs.next()){
                int id=rs.getInt("id");
                int c_id=rs.getInt("company_id");
                String title=rs.getString("title");
                String desc=rs.getString("description");
                String inds=rs.getString("industry");
                String loc=rs.getString("location");

                System.out.println("|"+id+"|"+c_id+"|"+title+"|"+desc+"|"+inds+"|"+loc+"|");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //To Read Job Roles By specific ID
    public void getByID(int sid){
        String sql="SELECT * FROM job_roles WHERE id=?";

        try{Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
               ps.setInt(1,sid);
               try(ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        int id=rs.getInt("id");
                        int c_id=rs.getInt("company_id");
                        String title=rs.getString("title");
                        String desc=rs.getString("description");
                        String inds=rs.getString("industry");
                        String loc=rs.getString("location");
                        System.out.println("Record Found!");
                        System.out.println("|"+id+"|"+c_id+"|"+title+"|"+desc+"|"+inds+"|"+loc+"|");
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
    

    //To delete job roles by their ID
    public void delete(int cid){
        String sql="DELETE FROM job_roles WHERE id=?";
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
