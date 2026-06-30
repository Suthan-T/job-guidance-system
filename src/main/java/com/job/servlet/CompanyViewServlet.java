package com.job.servlet;

import java.io.IOException;

import com.job.service.CompaniesService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/companies")
public class CompanyListServlet extends HttpServlet {

    private CompaniesService service;

    @Override
    public void init() {
        service = new CompaniesService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        service.getAllCompanies();

        response.getWriter().println("Check Console for Company List");

    }

}