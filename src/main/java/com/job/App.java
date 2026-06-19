package com.job;

import com.job.dao.JobRolesDAO;

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

        //JobSpecialization jobspecial=new JobSpecialization(1,"Freshers","Real time Hands on experience","20000");
        //JobSpecialDAO dao=new JobSpecialDAO();
        //dao.addJobSpecial(jobspecial);

        /*Scanner sc= new Scanner(System.in);
        System.out.print("Enter your Experience: ");
        String experience=sc.nextLine();
        
        JobSpecialization jobspecial=new JobSpecialization(1,experience,"Build new features","35000");
        JobSpecialDAO dao=new JobSpecialDAO();
        dao.updateJobSp(jobspecial); 
        */
       
      // Companies companies= new Companies();
       //CompaniesDAO dao=new CompaniesDAO();
       //dao.getByID(2);

       JobRolesDAO dao=new JobRolesDAO();
       dao.getByID(2);
       
      //JobSpecialDAO dao=new JobSpecialDAO();
       //dao.getByID(3);; 
}

}