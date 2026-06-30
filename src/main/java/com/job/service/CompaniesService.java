package com.job.service;

import java.util.List;

import com.job.dao.CompaniesDAO;
import com.job.model.Companies;

public class CompaniesService {

    private CompaniesDAO companyDAO;

    public CompaniesService() {
        companyDAO = new CompaniesDAO();
    }

    // Add Company
    public boolean addCompany(Companies company) {

        if (company == null) {
            return false;
        }

        if (company.getName() == null || company.getName().trim().isEmpty()) {
            return false;
        }

        return companyDAO.addCompany(company);
    }

    // Get All Companies
    public List<Companies> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    // Get Company By ID
    public Companies getCompanyById(int id) {

        if (id <= 0) {
            return null;
        }

        return companyDAO.getCompanyById(id);
    }

    // Update Company
    public boolean updateCompany(Companies company) {

        if (company == null || company.getId() <= 0) {
            return false;
        }

        return companyDAO.updateCompany(company);
    }

    // Delete Company
    public boolean deleteCompany(int id) {

        if (id <= 0) {
            return false;
        }

        return companyDAO.deleteCompany(id);
    }
}