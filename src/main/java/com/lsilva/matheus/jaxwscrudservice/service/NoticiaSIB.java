package com.lsilva.matheus.jaxwscrudservice.service;


import com.lsilva.matheus.jaxwscrudservice.config.databaseconfig.DataBaseConfiguration;
import com.lsilva.matheus.jaxwscrudservice.config.databaseconfig.DbException;
import com.lsilva.matheus.jaxwscrudservice.model.Noticia;
import com.lsilva.matheus.jaxwscrudservice.repository.NoticiaRepository;
import com.lsilva.matheus.jaxwscrudservice.repository.NoticiaRepositoryImpl;
import jakarta.jws.WebService;

import java.sql.Connection;
import java.util.List;

@WebService(endpointInterface = "com.lsilva.matheus.jaxwscrudservice.service.NoticiaSEI")
public class NoticiaSIB implements NoticiaSEI {


    @Override
    public Long adicionar(Noticia noticia) {
        Connection connection = DataBaseConfiguration.getConnection();
        NoticiaRepository repository = new NoticiaRepositoryImpl(connection);
        Long id;

        try {
            id = repository.adicionar(noticia);
        } catch (DbException e) {
            throw new DbException(e.getMessage());
        }
        return id;
    }

    @Override
    public Noticia alterar(Noticia noticia) {
        Connection connection = DataBaseConfiguration.getConnection();
        NoticiaRepository repository = new NoticiaRepositoryImpl(connection);
        Noticia noticiaResult;

        try {
            noticiaResult = repository.alterar(noticia);
        } catch (DbException e) {
            throw new DbException(e.getMessage());
        }
        return noticiaResult;
    }

    @Override
    public boolean apagar(Long id) {
        Connection connection = DataBaseConfiguration.getConnection();
        NoticiaRepository repository = new NoticiaRepositoryImpl(connection);
        boolean result = false;
        try {
            result = repository.apagar(id);
        } catch (DbException e) {
            throw new DbException(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Noticia> listar() {
        Connection connection = DataBaseConfiguration.getConnection();
        NoticiaRepository repository = new NoticiaRepositoryImpl(connection);
        List<Noticia> noticiaResultList;

        try {
            noticiaResultList = repository.listar();
        } catch (DbException e) {
            throw new DbException(e.getMessage());
        }
        return noticiaResultList;
    }

    @Override
    public Noticia ler(Long id) {
        Connection connection = DataBaseConfiguration.getConnection();
        NoticiaRepository repository = new NoticiaRepositoryImpl(connection);
        Noticia noticiaResult;

        try {
            noticiaResult = repository.ler(id);
        } catch (DbException e) {
            throw new DbException(e.getMessage());
        }
        return noticiaResult;
    }
}
