package com.lsilva.matheus.jaxwscrudservice.repository;

import com.lsilva.matheus.jaxwscrudservice.model.Noticia;
import java.sql.SQLException;
import java.util.List;

public interface NoticiaRepository {

    Long adicionar(Noticia noticia) throws SQLException;
    Noticia alterar(Noticia noticia) throws SQLException;
    boolean apagar(Long id) throws SQLException;
    List<Noticia> listar() throws SQLException;
    Noticia ler(Long id) throws SQLException;
}
