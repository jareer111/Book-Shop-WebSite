package com.jareer.bookshopwebsite.servlets.books;

import com.jareer.bookshopwebsite.dao.BookDAO;
import com.jareer.bookshopwebsite.dto.BookDetailsDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
@MultipartConfig(location = "home/javohir/apps/library/upload")
public class BookServlet extends HttpServlet {

    private static final Path path=Path.of(System.getProperty("user.home"),"/apps/library/upload");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO=BookDAO.getInstance();
        List<BookDetailsDTO> all = bookDAO.findAll();
        request.setAttribute("books", all);
        for (BookDetailsDTO bookDetailsDTO : all) {
            System.out.println("bookDetailsDTO.getCoverGeneratedFileName() = " + bookDetailsDTO.getCoverGeneratedFileName());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/books/books.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
