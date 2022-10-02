package com.lsilva.matheus.jaxwscrudservice.repository;

import com.lsilva.matheus.jaxwscrudservice.config.databaseconfig.DbException;
import com.lsilva.matheus.jaxwscrudservice.model.Noticia;
import com.lsilva.matheus.jaxwscrudservice.utils.DataUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticiaRepositoryImpl implements NoticiaRepository {

    private final Connection connection;

    public NoticiaRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long adicionar(Noticia noticia) throws DbException {
        long id = 0L;
        try (Statement statement = this.connection.createStatement()) {
            String dataHora = DataUtils.formatarData(noticia.getData());
            String sql = String.format("insert into noticia (titulo, texto, data_publicacao) values ('%s', '%s', '%s') returning id;",
                    noticia.getTitulo(), noticia.getTexto(), dataHora);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                id = resultSet.getLong(1);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return id;
    }

    @Override
    public Noticia alterar(Noticia noticia) throws DbException {
        String sql = "update noticia set titulo = ? , texto = ? , data_publicacao = ? where id = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, noticia.getTitulo());
            preparedStatement.setString(2, noticia.getTexto());
            preparedStatement.setDate(3, DataUtils.converterDateParaSqlDate(noticia.getData().getTime()));
            preparedStatement.setLong(4, noticia.getId());
            preparedStatement.execute();
            return this.ler(noticia.getId());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public boolean apagar(Long id) throws DbException {
        String sql = "delete from noticia where id = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Noticia> listar() throws DbException {
        List<Noticia> noticias = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            String sql = "select * from noticia;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
                noticias.add(
                        new Noticia(
                                resultSet.getLong("id"),
                                resultSet.getString("titulo"),
                                resultSet.getString("texto"),
                                DataUtils.converterDateResultSetTime(resultSet.getDate("data_publicacao").getTime())
                        )
                );
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return noticias;
    }

    @Override
    public Noticia ler(Long id) throws DbException {
        Noticia noticiaResult = null;
        try (Statement statement = this.connection.createStatement()) {
            String sql = String.format("select * from noticia where id = %d;", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                noticiaResult = new Noticia(
                        resultSet.getLong("id"),
                        resultSet.getString("titulo"),
                        resultSet.getString("texto"),
                        DataUtils.converterDateResultSetTime(resultSet.getDate("data_publicacao").getTime())
                );
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return noticiaResult;
    }
}
