package com.jareer.bookshopwebsite.dao;

import com.jareer.bookshopwebsite.domain.Document;
import com.jareer.bookshopwebsite.dto.DTO;
import com.jareer.bookshopwebsite.dto.DocumentDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentDAO extends DAO<Document, Integer> {
    public static final String SELECT_ALL_DOCUMENT = "select * from library1.document";
    public static final String SELECT_DOCUMENT = "select * from library1.document t where t.id = ?;";
    public static DocumentDAO instance;

    private final String INSERT_DOCUMENT = """
            insert into library1.document ( 
            generatedFileName,
            originalFileName,
            mimeType,
            filePath,
            fileSize,
            extension) values (?,?,?,?,?,?) returning id;""";
    private final String SELECT_BY_NEW_NAME = """
                            select * from library1.document t where t.generatedFileName = ?;
            """;

    @Override
    public Document save(Document document) {
        Connection connection = getConnection();
        try (var pr = connection.prepareStatement(INSERT_DOCUMENT)) {
            pr.setString(1, document.getGeneratedFileName());
            pr.setString(2, document.getOriginalFileName());
            pr.setString(3, document.getMimeType());
            pr.setString(4, document.getFilePath());
            pr.setLong(5, document.getFileSize());
            pr.setString(6, document.getExtension());
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()){
                document.setId(resultSet.getInt("id"));
            }else
                throw new RuntimeException("Interval server error");
            return document;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DocumentDTO> getAll(Integer integer) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOCUMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return List.of(
                        new DocumentDTO(
                                resultSet.getInt("id"),
                                resultSet.getString("generatedFileName"),
                                resultSet.getString("originalFileName"),
                                resultSet.getString("mimeType"),
                                resultSet.getString("filePath"),
                                resultSet.getString("extension"),
                                resultSet.getLong("fileSize")
                        ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    protected DTO get(Integer integer) {
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCUMENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new DocumentDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("generatedFileName"),
                        resultSet.getString("originalFileName"),
                        resultSet.getString("mimeType"),
                        resultSet.getString("filePath"),
                        resultSet.getString("extension"),
                        resultSet.getLong("fileSize")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    };

        @Override
        public boolean update (Document document){
            return false;
        }

        @Override
        public boolean delete (Integer integer){
               return false;
        }

        public Document findByGeneratedName (@NonNull String filename){
            Connection connection = getConnection();
            try (var pr = connection.prepareStatement(SELECT_BY_NEW_NAME)) {
                pr.setString(1, filename);
                ResultSet resultSet = pr.executeQuery();
                if (resultSet.next()) {
                    return Document.builder()
                            .id(resultSet.getInt("id"))
                            .generatedFileName(resultSet.getString("generatedFileName"))
                            .originalFileName(resultSet.getString("originalFileName"))
                            .mimeType(resultSet.getString("mimeType"))
                            .filePath(resultSet.getString("filePath"))
                            .extension(resultSet.getString("extension"))
                            .fileSize(resultSet.getLong("fileSize"))
                            .build();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static DocumentDAO getInstance () {
            if (instance == null) {
                synchronized (DocumentDAO.class) {
                    if (instance == null) {
                        instance = new DocumentDAO();
                    }
                }
            }
            return instance;
        }
    }
