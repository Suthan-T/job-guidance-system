package com.job;

import com.job.dao.JobRolesDAO;
import com.job.model.JobRoles;


public class App 
{
    public static void main( String[] args )
    {
        //Companies companies=new Companies("Google", "Top 1 MNC", "https://google.com", "California");
        //CompaniesDAO dao=new CompaniesDAO();
        //dao.addCompanies(companies);

        JobRoles jobroles=new JobRoles(1,"SDE","freshers interested to learn new skills","Top MNC","India");
        JobRolesDAO dao=new JobRolesDAO();
        dao.addJobRoles(jobroles);

   
}

}