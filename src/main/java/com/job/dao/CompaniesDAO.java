package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.job.model.Companies;
import com.job.util.DBConnection;

public class CompaniesDAO{
    //To add/insert companies record
    public boolean addCompany(Companies company){

        String sql="INSERT INTO companies(name, description, website, headquarters) VALUES(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
        	PreparedStatement ps=con.prepareStatement(sql)){
     
            ps.setString(1,company.getName());
            ps.setString(2,company.getDescription());
            ps.setString(3,company.getWebsite());
            ps.setString(4,company.getHeadquarters());

            int rows = ps.executeUpdate();

            return rows > 0;
        }

        catch(SQLException e){
            e.printStackTrace();
        }
		return false;
    }

    //To read all companies record
    public List<Companies> getAllCompanies(){
        String sql="SELECT * FROM companies";
        try (
            Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            List<Companies> companiesList = new ArrayList<>();
            while(rs.next()){
            	Companies company = new Companies();

            	company.setId(rs.getInt("id"));
            	company.setName(rs.getString("name"));
            	company.setDescription(rs.getString("description"));
            	company.setWebsite(rs.getString("website"));
            	company.setHeadquarters(rs.getString("headquarters"));

            	companiesList.add(company);
            }
            return companiesList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //To read companies by thier ID

    public Companies getCompanyById(int id) {
       String sql="SELECT * FROM companies WHERE id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
               ps.setInt(1,id);
               try(ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        Companies company=new Companies();
                        company.setId(rs.getInt("id"));
                        company.setName(rs.getString("name"));
                        company.setDescription(rs.getString("description"));
                        company.setWebsite(rs.getString("website"));
                        company.setHeadquarters(rs.getString("headquarters"));

                        return company;
                        //System.out.println("Record Found!");
                        //System.out.println("| "+id+" |"+name+" |"+desc+" |"+web+" |"+head+" |");
                    }
                   
                    }
               catch(SQLException e){
                   e.printStackTrace();
               }
            } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
        return null;

    }



    //To update companies description
    public boolean updateCompany(Companies company){
        String sql="UPDATE companies SET name=?, description=?,website=?,headquarters=? WHERE id=?";	        
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1, company.getName());
            ps.setString(2, company.getDescription());
            ps.setString(3, company.getWebsite());
            ps.setString(4, company.getHeadquarters());
            ps.setInt(5, company.getId());
            int rows = ps.executeUpdate();

            return rows > 0;

            //System.out.print("Company Description Updated");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //To delete companies by ID
    public boolean deleteCompany(int cid){
        String sql="DELETE FROM companies WHERE id=?";
        try (
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1, cid);
            int affected=ps.executeUpdate();

            	return affected > 0;
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}