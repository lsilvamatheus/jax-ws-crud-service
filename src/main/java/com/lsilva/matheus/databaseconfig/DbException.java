package com.lsilva.matheus.databaseconfig;

public class DbException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public DbException(String message) {
        super(message);
    }
}
