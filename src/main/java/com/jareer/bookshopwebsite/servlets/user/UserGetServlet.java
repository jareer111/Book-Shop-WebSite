package com.jareer.bookshopwebsite.servlets.user;

import com.google.gson.Gson;
import com.jareer.bookshopwebsite.dao.UserDAO;
import com.jareer.bookshopwebsite.dto.UserDetailsDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserGetServlet", urlPatterns = "/users/get/*")
public class UserGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userChatID = Long.parseLong(request.getPathInfo().substring(1));
        UserDetailsDTO user = UserDAO.getInstance().findById(userChatID);
        Gson gson = new Gson();
        String jsonDATA = gson.toJson(user);
        response.setContentType("application/json");
        response.getWriter().println(jsonDATA);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
