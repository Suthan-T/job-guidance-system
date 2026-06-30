package com.job.servlet;

import java.io.IOException;

import com.job.model.Companies;
import com.job.service.CompaniesService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addCompany")
public class CompanyAddServlet extends HttpServlet {

    private CompaniesService service;

    @Override
    public void init() {
        service = new CompaniesService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String website = request.getParameter("website");
        String headquarters = request.getParameter("headquarters");

        Companies company = new Companies();

        company.setName(name);
        company.setDescription(description);
        company.setWebsite(website);
        company.setHeadquarters(headquarters);

        service.addCompany(company);

        response.sendRedirect("companies");
    }

}