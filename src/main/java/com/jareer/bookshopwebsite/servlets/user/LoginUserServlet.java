package com.jareer.bookshopwebsite.servlets.user;

import com.jareer.bookshopwebsite.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.jareer.bookshopwebsite.dao.UserDAO.check;

@WebServlet(name = "LoginUserServlet", value = "/login")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("user/sign_up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.getInstance();
        String loginEmail = request.getParameter("login_email");
        String loginPassword = request.getParameter("login_password");
        String check = check(loginEmail, loginPassword);
        if (check != null) {
            request.setAttribute("error", check);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/sign_up.jsp");
            requestDispatcher.forward(request, response);
        } else if (userDAO.login_check(loginEmail, loginPassword)) {
            response.sendRedirect("/main");
        }else {
            request.setAttribute("error", "Wrong email or password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/sign_up.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
