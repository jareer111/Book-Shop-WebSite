package com.jareer.bookshopwebsite.servlets.books;

import com.jareer.bookshopwebsite.dao.BookDAO;
import com.jareer.bookshopwebsite.dao.CategoryDAO;
import com.jareer.bookshopwebsite.dao.DocumentDAO;
import com.jareer.bookshopwebsite.domain.Book;
import com.jareer.bookshopwebsite.domain.Category;
import com.jareer.bookshopwebsite.domain.Document;
import com.jareer.bookshopwebsite.utils.Resizer;
import com.jareer.bookshopwebsite.utils.StringUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("ReassignedVariable")
@WebServlet(name = "BookAddServlet", value = "/books/add")
@MultipartConfig(location = "/home/javohir/apps/library/upload")
public class BookAddServlet extends HttpServlet {

    private static final Path rootPath = Path.of(System.getProperty("user.home"), "/apps/library/upload");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        List<Category> categoryDAOAll = categoryDAO.findAll();
        req.setAttribute("categories", categoryDAOAll);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/books/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Part image = request.getPart("image");
        Part file = request.getPart("file");

        BookDAO bookDAO = BookDAO.getInstance();
        String bookName = request.getParameter("book_name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String publishDate = request.getParameter("publish_date");
        String description = request.getParameter("description");
        int bookCategorie = Integer.parseInt(request.getParameter("book_categorie"));
        Document fileDocument = saveFile(file);
        Document imageDocument = saveCover(image);

        Book book = Book.
                builder().
                title(bookName).
                author(author).
                publisher(publisher).
                publishedDate(LocalDateTime.parse(publishDate)).
                createdAt(LocalDateTime.now()).
                categoryId(bookCategorie).
                description(description).
                coverId(imageDocument.getId()).
                documentId(fileDocument.getId()).
                build();
        bookDAO.save(book);
        resp.sendRedirect("/user/home");

    }

    private Document saveCover(Part part) {
        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String generateUniqueName = StringUtils.generateUniqueName(part);
            Path coverPath = rootPath.resolve(generateUniqueName);
            String originalName = part.getSubmittedFileName();
            String extension = StringUtils.getFileExtension(originalName);
            String mimeType = part.getContentType();
            String fullpath = rootPath.resolve(generateUniqueName).toString();
            Document document = Document.builder()
                    .generatedFileName(generateUniqueName)
                    .originalFileName(originalName)
                    .fileSize(part.getSize())
                    .mimeType(mimeType)
                    .filePath(fullpath)
                    .extension(extension)
                    .build();

            document = documentDAO.save(document);
            InputStream inputStream = Resizer.resizeImage(part.getInputStream(), StringUtils.getFileExtension(part), 150, 220);

            OutputStream outputStrea = new FileOutputStream(fullpath);
            outputStrea.write(inputStream.readAllBytes());
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Document saveFile(Part file) {

        try {
            DocumentDAO documentDAO = DocumentDAO.getInstance();
            String originalName = file.getSubmittedFileName();
            String extension = StringUtils.getFileExtension(originalName);
            String generatedName = StringUtils.generateUniqueName(file);
            String mimeType = file.getContentType();
            long size = file.getSize();
            Document document = Document.builder()
                    .generatedFileName(generatedName)
                    .originalFileName(originalName)
                    .fileSize(size)
                    .mimeType(mimeType)
                    .filePath(rootPath.resolve(generatedName).toString())
                    .extension(extension)
                    .build();
            document = documentDAO.save(document);
            file.write(generatedName);
            return document;
        } catch (Exception e) {
            // TODO: 08/02/23 redirect to error page
            throw new RuntimeException(e);
        }
    }
}
