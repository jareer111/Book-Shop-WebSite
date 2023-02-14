package com.jareer.bookshopwebsite.dao;

import com.jareer.bookshopwebsite.domain.Users;
import com.jareer.bookshopwebsite.dto.DTO;
import com.jareer.bookshopwebsite.dto.UserDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UserDAO extends DAO<Users, Integer> {
    public static final String FIND_ALL_QUERY = """
    select * from library1.users order by username offset ? limit ? """;
    public static final String INSERT_USER = "insert into library1.users(username,password,email,role,is_active)values (?,?,?,?,?) returning id;";
    public static final String SELECT_CHECK_USER = "select * from library1.users where is_active = true AND email = ? and password = ?;";
    public static final String DELETE_USER_QUERY = "update library1.users set is_active = false where id = ?;";
    public static final String TOTAL_USER = "select count(0) from library1.users ;";
    private static UserDAO instance;


    @Override
    public Users save(Users users) {
        Connection connection = getConnection();
        StringJoiner roles = new StringJoiner(",");
        users.getRole().stream().forEach(roles::add);
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getPassword());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, roles.toString());
            preparedStatement.setBoolean(5, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                users.setId(resultSet.getLong("id"));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DTO get(Integer integer) {
        return null;
    }

    @Override
    public List<? extends DTO> getAll(Integer integer) {
        return null;
    }

    @Override
    protected boolean update(Users users) {
        return false;
    }


    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null)
                    instance = new UserDAO();
            }
        }
        return instance;
    }


    public boolean login_check(String loginEmail, String loginPassword) {
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHECK_USER)) {
            preparedStatement.setString(1, loginEmail);
            preparedStatement.setString(2, loginPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDetailsDTO findById(long userID) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("select * from library1.users  where id = ?;")) {
            pr.setLong(1, userID);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                return UserDetailsDTO.builder().
                        id(rs.getLong("id")).
                        username(rs.getString("username")).
                        email(rs.getString("email")).
                        roleList(List.of(rs.getString("role").split(","))).
                        isActive(rs.getBoolean("is_active")).build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public List<Users> findAll(short page, short size) {
        ArrayList<Users> users = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY)) {
            preparedStatement.setShort(1, page);
            preparedStatement.setShort(2, size);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(List.of(resultSet.getString("role").split(",")));
                user.setIsActive(resultSet.getBoolean("is_active"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }




    public void deleteById(long id) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(DELETE_USER_QUERY)) {
            pr.setLong(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long totalCount() {
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static String check(String username, String email, String password, String confirmationPassword) {
        String x = check(email, password);
        if (x != null) return x;

        if (username == null || username.isEmpty()) {
            return "Username is required";
        }

        if (confirmationPassword == null || confirmationPassword.isEmpty()) {
            return "Confirmation password is required";
        }
        if (!password.equals(confirmationPassword)) {
            return "Password and confirmation password must be same";
        }
        return null;
    }

    public static String check(String email, String password) {

        if (email == null || email.isEmpty()) {
            return "Email is required";
        }

        if (password == null || password.isEmpty()) {
            return "Password is required";
        }
        return null;
    }


}
