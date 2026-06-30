package com.job.servlet;

import java.io.IOException;
import java.util.List;

import com.job.model.Companies;
import com.job.service.CompaniesService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CompaniesService companyService;

    @Override
    public void init() {
        companyService = new CompaniesService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

        case "list":
            listCompanies(request, response);
            break;

        case "view":
            viewCompany(request, response);
            break;

        case "delete":
            deleteCompany(request, response);
            break;

        default:
            listCompanies(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {

        case "add":
            addCompany(request, response);
            break;

        case "update":
            updateCompany(request, response);
            break;

        }

    }

    private void addCompany(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Companies company = new Companies();

        company.setName(request.getParameter("name"));
        company.setDescription(request.getParameter("description"));
        company.setWebsite(request.getParameter("website"));
        company.setHeadquarters(request.getParameter("headquarters"));

        companyService.addCompany(company);

        response.sendRedirect("company?action=list");

    }

    private void listCompanies(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Companies> companies = companyService.getAllCompanies();

        request.setAttribute("companies", companies);

        request.getRequestDispatcher("/company-list.jsp")
                .forward(request, response);

    }

    private void viewCompany(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Companies company = companyService.getCompanyById(id);

        request.setAttribute("company", company);

        request.getRequestDispatcher("/company-view.jsp")
                .forward(request, response);

    }

    private void updateCompany(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Companies company = new Companies();

        company.setId(Integer.parseInt(request.getParameter("id")));
        company.setName(request.getParameter("name"));
        company.setDescription(request.getParameter("description"));
        company.setWebsite(request.getParameter("website"));
        company.setHeadquarters(request.getParameter("headquarters"));

        companyService.updateCompany(company);

        response.sendRedirect("company?action=list");

    }

    private void deleteCompany(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        companyService.deleteCompany(id);

        response.sendRedirect("company?action=list");

    }

}