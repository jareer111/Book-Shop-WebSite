package com.jareer.bookshopwebsite.servlets.books;

import com.jareer.bookshopwebsite.dao.BookDAO;
import com.jareer.bookshopwebsite.dao.CategoryDAO;
import com.jareer.bookshopwebsite.domain.Category;
import com.jareer.bookshopwebsite.dto.BookDetailsDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyServlet", value = "/user/home")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = BookDAO.getInstance();
        List<BookDetailsDTO> all = bookDAO.findAll();
        List<Category> categoryList = new CategoryDAO().findAll();
        request.setAttribute("categories", categoryList);
        request.setAttribute("books", all);
        request.getRequestDispatcher("/books/home-page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
