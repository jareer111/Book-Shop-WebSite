package com.jareer.bookshopwebsite.servlets.user;


import com.jareer.bookshopwebsite.dao.UserDAO;
import com.jareer.bookshopwebsite.dto.UserDetailsDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", urlPatterns = "/users/delete/*")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.getInstance();
        String pathInfo = request.getPathInfo();
        long userID = Long.parseLong(pathInfo.substring(1));
        UserDetailsDTO user = userDAO.findById(userID);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.deleteById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/users");
    }
}
