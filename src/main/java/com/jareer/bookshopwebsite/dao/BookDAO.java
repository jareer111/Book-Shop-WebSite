package com.jareer.bookshopwebsite.dao;

import com.jareer.bookshopwebsite.domain.Book;
import com.jareer.bookshopwebsite.dto.BookDTO;
import com.jareer.bookshopwebsite.dto.BookDetailsDTO;
import com.jareer.bookshopwebsite.dto.DTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDAO extends DAO<Book, Integer> {
    public static final String INSERT_QUERY = """
            insert into library1.book(title,author,publisher,published_date,created_at,category_id,description, cover_id,document_id ) values (?, ?, ?, ?, ?, ?, ? ,? ,?);""";

    private static final String SELECT_ALL = """
            select b.id, b.title, b.author,b.description, b.views,b.likes, b.dislikes, b.downloads,b.publisher,b.published_date,
             d.originalFileName as coverOriginalFileName ,d.generatedFileName as coverGeneratedFileName,d.fileSize as coverFileSize, 
             d2.originalFileName as documentOriginalFileName ,d2.generatedFileName as documentGeneratedFileName,d2.fileSize as documentFileSize,
              c.name as category 
              from book b 
             inner join document d on b.cover_id = d.id 
             inner join document d2 on b.document_id = d2.id 
             inner join category c on b.category_id = c.id;
                        """;
    private static final String SELECT_BOOKS_BY_ID = """
            select b.id, b.title, b.author,b.description, b.views,b.likes, b.dislikes, b.downloads,b.publisher,b.published_date,
                         d.originalFileName as coverOriginalFileName ,d.generatedFileName as coverGeneratedFileName,d.fileSize as coverFileSize,
                         d2.originalFileName as documentOriginalFileName ,d2.generatedFileName as documentGeneratedFileName,d2.fileSize as documentFileSize,
                          c.name as category
                          from book b 
                         inner join document d on b.cover_id = d.id
                         inner join document d2 on b.document_id = d2.id
                         inner join category c on b.category_id = c.id 
                         WHERE b.id = ?
                         ;
            """;
    private static BookDAO instance;

    @Override
    public Book save(Book book) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(INSERT_QUERY)) {
            pr.setString(1, book.getTitle());
            pr.setString(2, book.getAuthor());
            pr.setString(3, book.getPublisher());
            pr.setTimestamp(4, Timestamp.valueOf(book.getPublishedDate()));
            pr.setTimestamp(5, Timestamp.valueOf(book.getCreatedAt()));
            pr.setInt(6, book.getCategoryId());
            pr.setString(7, book.getDescription());
            pr.setInt(8, book.getCoverId());
            pr.setInt(9, book.getDocumentId());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DTO get(Integer integer) {
        return null;
    }

    @Override
    public List<BookDTO> getAll(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            synchronized (BookDAO.class) {
                if (instance == null) {
                    instance = new BookDAO();
                }
            }
        }
        return instance;
    }

    public List<BookDetailsDTO> findAll() {

        Connection connection = getConnection();
        List<BookDetailsDTO> books = new ArrayList<>();

        try (var pr = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                books.add(BookDetailsDTO.builder().
                        id(resultSet.getInt("id")).
                        title(resultSet.getString("title")).
                        author(resultSet.getString("author")).
                        description(resultSet.getString("description")).
                        likes(resultSet.getInt("likes")).
                        dislikes(resultSet.getInt("dislikes")).
                        views(resultSet.getInt("views")).
                        category(resultSet.getString("category")).
                        publisher(resultSet.getString("publisher")).
                        publishedDate(resultSet.getTimestamp("published_date").toLocalDateTime()).
                        coverOriginalFileName(resultSet.getString("coverOriginalFileName")).
                        coverGeneratedFileName(resultSet.getString("coverGeneratedFileName")).
                        coverFileSize((resultSet.getLong("coverFileSize") / 2 << 20) + "MB").
                        documentOriginalFileName(resultSet.getString("documentOriginalFileName")).
                        documentGeneratedFileName(resultSet.getString("documentGeneratedFileName")).
                        documentFileSize((resultSet.getLong("documentFileSize") / 2 << 20) + "MB").
                        build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public BookDetailsDTO getBookById(int i) {

        Connection connection = getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_ID)) {
            preparedStatement.setInt(1, i);

            ResultSet resultSet = preparedStatement.executeQuery();
            BookDetailsDTO bookDetailsDTO=null;
            while (resultSet.next()) {
                bookDetailsDTO = BookDetailsDTO.builder().
                        id(resultSet.getInt("id")).
                        title(resultSet.getString("title")).
                        author(resultSet.getString("author")).
                        description(resultSet.getString("description")).
                        likes(resultSet.getInt("likes")).
                        dislikes(resultSet.getInt("dislikes")).
                        views(resultSet.getInt("views")).
                        category(resultSet.getString("category")).
                        publisher(resultSet.getString("publisher")).
                        publishedDate(resultSet.getTimestamp("published_date").toLocalDateTime()).
                        coverOriginalFileName(resultSet.getString("coverOriginalFileName")).
                        coverGeneratedFileName(resultSet.getString("coverGeneratedFileName")).
                        coverFileSize((resultSet.getLong("coverFileSize") / 2 << 20) + "MB").
                        documentOriginalFileName(resultSet.getString("documentOriginalFileName")).
                        documentGeneratedFileName(resultSet.getString("documentGeneratedFileName")).
                        documentFileSize((resultSet.getLong("documentFileSize") / 2 << 20) + "MB").
                        build();
            }
            return bookDetailsDTO;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
