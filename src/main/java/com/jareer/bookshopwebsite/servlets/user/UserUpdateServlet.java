package com.jareer.bookshopwebsite.servlets.user;

import com.jareer.bookshopwebsite.dao.UserDAO;
import com.jareer.bookshopwebsite.dto.UserDetailsDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.io.IOException;

@Log
@WebServlet(name = "UserUpdateServlet", urlPatterns = "/users/update/*")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDao = UserDAO.getInstance();
        String pathInfo = request.getPathInfo();
        long userID = Long.parseLong(pathInfo.substring(1));
        UserDetailsDTO user = userDao.findById(userID);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/update.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserDAO userDao = UserDAO.getInstance();
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        Long id = Long.parseLong(request.getParameter("id"));
//        UserUpdateDTO userUpdateDTO = new UserUpdateDTO(id, username, email, password);
//        userDao.update(userUpdateDTO);
//        response.sendRedirect("/users");
    }
}
