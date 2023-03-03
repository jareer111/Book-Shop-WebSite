package com.jareer.bookshopwebsite.servlets.category;

import com.jareer.bookshopwebsite.dao.CategoryDAO;
import com.jareer.bookshopwebsite.domain.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CategoryAddServlet", value = "/category/add")
public class CategoryAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/category/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        String categoryName = request.getParameter("category_name");

        Category category = Category.
                builder().
                name(categoryName).
                build();
        categoryDAO.save(category);
        response.sendRedirect("/user/main");

    }
}
