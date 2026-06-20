package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.job.model.JobSpecialization;
import com.job.util.DBConnection;

public class JobSpecialDAO{

    //To add/insert job Specifications
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

    //To read all Job Specifications
     public void getAllJobSpecify(){
        String sql="SELECT * FROM job_specifications";

        try (
            Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){
            System.out.println("|ID|JOB_ID|Experience_Level|Responsibilities|Salary_Range|");
            System.out.println("-------------------------------------------------------");

            while(rs.next()){
                int id=rs.getInt("id");
                int j_id=rs.getInt("job_id");
                String exp=rs.getString("experience_level");
                String resp=rs.getString("responsibilities");
                String sala=rs.getString("salary_range");
                
                System.out.println("|"+id+"|"+j_id+"|"+exp+"|"+resp+"|"+sala+"|");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //To read job specification by ID
    public void getByID(int sid){
        String sql="SELECT * FROM job_specifications WHERE id=?";

        try{Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
               ps.setInt(1,sid);
               try(ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                         int id=rs.getInt("id");
                        int j_id=rs.getInt("job_id");
                        String exp=rs.getString("experience_level");
                        String resp=rs.getString("responsibilities");
                        String sala=rs.getString("salary_range");
                        System.out.println("Record Found!");
                        System.out.println("|"+id+"|"+j_id+"|"+exp+"|"+resp+"|"+sala+"|");
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

    //To update job specificaion description
    public void updateJobSp(JobSpecialization jobspecial){
        String sql="UPDATE job_specifications SET experience_level=? WHERE job_id=?";

        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1, jobspecial.getExperience());
            ps.setInt(2, jobspecial.getJid());

            ps.executeUpdate();

            System.out.print("Job Specification Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //To delete job specification by their ID
    public void delete(int cid){
        String sql="DELETE FROM job_specifications WHERE id=?";
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
