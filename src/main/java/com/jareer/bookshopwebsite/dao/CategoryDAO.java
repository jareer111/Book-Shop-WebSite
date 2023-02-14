package com.jareer.bookshopwebsite.dao;

import com.jareer.bookshopwebsite.domain.Category;
import com.jareer.bookshopwebsite.dto.CategoryDTO;
import com.jareer.bookshopwebsite.dto.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO<Category, Integer> {
    public static final String UPDATE_CATEGORY_NAME = "UPDATE library1.name SET name=? WHERE id=?;";
    public static CategoryDAO instance;

    public static final String FIND_ALL_CATEGORIES = "select * from library1.category where is_deleted=false;";

    public static final String INSERT_CATEGORY = "insert into library1.category (name) values (?);";
    public static final String SELECT_ALL_CATEGORY = "select * from library1.category where is_deleted=true;";
    public static final String SELECT_CATEGORY = "select * from library1.category where id = ? and is_deleted=true;";
    public static final String DELETE_CATEGORY = "update category set is_deleted = true where id= ?;";

    @Override
    public Category save(Category category) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<CategoryDTO> getAll(Integer integer) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<CategoryDTO> categories = new ArrayList<>();
            while (resultSet.next()) {
                CategoryDTO categoryDTO = new CategoryDTO(resultSet.getInt("id"),
                        resultSet.getString("name"));
                categories.add(categoryDTO);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DTO get(Integer integer) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new CategoryDTO(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean update(Category category) {

        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_NAME)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());
            int update = preparedStatement.executeUpdate();
            return (update == 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer integer) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
            int i = preparedStatement.executeUpdate();
            return i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static CategoryDAO getInstance() {
        if (instance == null) {
            synchronized (CategoryDAO.class) {
                if (instance == null) {
                    instance = new CategoryDAO();
                }
            }
        }
        return instance;
    }

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CATEGORIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(Category.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
