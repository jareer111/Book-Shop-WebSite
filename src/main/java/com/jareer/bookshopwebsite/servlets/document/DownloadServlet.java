package com.jareer.bookshopwebsite.servlets.document;

import com.jareer.bookshopwebsite.dao.DocumentDAO;
import com.jareer.bookshopwebsite.domain.Document;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    private static final Path rootPath = Path.of("/home/javohir/apps/library/upload");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        String forDownload = request.getParameter("download");
        DocumentDAO documentDAO = DocumentDAO.getInstance();
        Document document = documentDAO.findByGeneratedName(filename);
        Path filePath = rootPath.resolve(filename);
        response.setContentType(document.getMimeType());
        if (forDownload != null)
            response.addHeader("Content-Disposition", "attachment; filename=" + document.getOriginalFileName());
        response.getOutputStream().write(Files.readAllBytes(filePath));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
