package com.job;

import com.job.model.Companies;
import com.job.dao.CompaniesDAO;

public class App 
{
    public static void main( String[] args )
    {
        Companies companies=new Companies("Google", "Top 1 MNC", "https://google.com", "California");
    

    CompaniesDAO dao=new CompaniesDAO();

    dao.addCompanies(companies);
}

}