package com.jareer.bookshopwebsite.dao;

import com.jareer.bookshopwebsite.dto.DTO;
import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T, ID> {
    private final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    DriverManager.registerDriver(new Driver());
                    return DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/book_shop?currentSchema=library1",
                            "postgres",
                            "123"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );

    protected abstract T save(T t);

    protected abstract DTO get(ID id);

    protected abstract List<? extends DTO> getAll(ID id);

    protected abstract boolean update(T t);

    protected abstract boolean delete(ID id);

    protected Connection getConnection() {
        return connectionThreadLocal.get();
    }

    public String decodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public boolean checkPassword(@NonNull String password, @NonNull String codePassword) {
        return BCrypt.checkpw(password, codePassword);
    }

}
