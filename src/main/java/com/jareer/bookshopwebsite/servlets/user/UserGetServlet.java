package com.jareer.bookshopwebsite.servlets.user;

import com.google.gson.Gson;
import com.jareer.bookshopwebsite.dao.UserDAO;
import com.jareer.bookshopwebsite.domain.Users;
import dev.jareer.lessontwoservletjsp.dao.StudentDao;
import dev.jareer.lessontwoservletjsp.domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentGetServlet", urlPatterns = "/students/get/*")
public class StudentGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userChatID = Long.parseLong(request.getPathInfo().substring(1));
        Users student = UserDAO.getInstance().findById(userChatID);
        Gson gson = new Gson();
        String jsonDATA = gson.toJson(student);
        response.setContentType("application/json");
        response.getWriter().println(jsonDATA);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
