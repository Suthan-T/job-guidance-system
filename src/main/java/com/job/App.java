package com.job;

import com.job.dao.JobSpecialDAO;
import com.job.model.JobSpecialization;

public class App 
{
    public static void main( String[] args )
    {
        //Companies companies=new Companies("Google", "Top 1 MNC", "https://google.com", "California");
        //CompaniesDAO dao=new CompaniesDAO();
        //dao.addCompanies(companies);

        //JobRoles jobroles=new JobRoles(1,"SDE","freshers interested to learn new skills","Top MNC","India");
        //JobRolesDAO dao=new JobRolesDAO();
        //dao.addJobRoles(jobroles);

        JobSpecialization jobspecial=new JobSpecialization(1,"Freshers","Real time Hands on experience","20000");
        JobSpecialDAO dao=new JobSpecialDAO();
        dao.addJobSpecial(jobspecial);

   
}

}