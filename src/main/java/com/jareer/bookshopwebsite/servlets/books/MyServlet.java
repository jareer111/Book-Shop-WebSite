package com.jareer.bookshopwebsite.servlets.books;

import com.jareer.bookshopwebsite.dao.BookDAO;
import com.jareer.bookshopwebsite.dto.BookDetailsDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyServlet", value = "/addition/home")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = BookDAO.getInstance();
        List<BookDetailsDTO> all = bookDAO.findAll();
        System.out.println("all.get(1).getId() = " + all.get(1).getId());
        request.setAttribute("books", all);
        request.getRequestDispatcher("/addition/home2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
