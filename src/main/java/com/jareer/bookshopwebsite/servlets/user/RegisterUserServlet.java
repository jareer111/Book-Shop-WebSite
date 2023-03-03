package com.jareer.bookshopwebsite.servlets.user;

import com.jareer.bookshopwebsite.dao.UserDAO;
import com.jareer.bookshopwebsite.domain.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

import static com.jareer.bookshopwebsite.dao.UserDAO.check;

@WebServlet(name = "RegisterUserServlet", value = "/register")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", null);
        request.getRequestDispatcher("user/sign_up.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirmation_password");
        String check = check(username, email, password, confirmationPassword);

        String Bpassword = BCrypt.hashpw(password, BCrypt.gensalt());

        if (check != null) {
            request.setAttribute("error", check);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/sign_up.jsp");
            requestDispatcher.forward(request, response);
        } else {
            Users user = Users.builder().username(username).email(email).password(Bpassword).build();
            UserDAO userDAO = UserDAO.getInstance();
            userDAO.save(user);
            response.sendRedirect("/main");
        }
    }
}
