package com.jareer.bookshopwebsite.servlets.user;

import com.jareer.bookshopwebsite.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.getInstance();
        short page = Short.parseShort(Objects.requireNonNullElse(request.getParameter("page"), "0"));
        short size = Short.parseShort(Objects.requireNonNullElse(request.getParameter("size"), "3"));
        long totalCount = userDAO.totalCount();
        long pageCount = totalCount / size;
        long currentPage = page;
        request.setAttribute("students", userDAO.findAll(page, size));
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("hasPrevious", currentPage > 0);
        request.setAttribute("hasNext", currentPage < pageCount);
        request.setAttribute("previous", page - 1);
        request.setAttribute("next", page + 1);
//        response.setIntHeader("Refresh", 2);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students/students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getMethod().equalsIgnoreCase("get"))
            resp.sendError(405, "Method not allowed");
        else
            super.service(req, resp);
    }

}
