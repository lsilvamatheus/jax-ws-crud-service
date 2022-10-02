package com.lsilva.matheus.jaxwscrudservice.repository;

import com.lsilva.matheus.jaxwscrudservice.config.databaseconfig.DbException;
import com.lsilva.matheus.jaxwscrudservice.model.Noticia;

import java.util.List;

public interface NoticiaRepository {

    Long adicionar(Noticia noticia) throws DbException;
    Noticia alterar(Noticia noticia) throws DbException;
    boolean apagar(Long id) throws DbException;
    List<Noticia> listar() throws DbException;
    Noticia ler(Long id) throws DbException;
}
