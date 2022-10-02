package com.lsilva.matheus.jaxwscrudservice.model;

import java.util.Date;
import java.util.Objects;

public class Noticia {

    public Noticia() {}
    public Noticia(Long id, String titulo, String texto, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
    }

    private Long id;
    private String titulo;
    private String texto;
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noticia noticia = (Noticia) o;
        return Objects.equals(id, noticia.id) && Objects.equals(titulo, noticia.titulo) && Objects.equals(texto, noticia.texto) && Objects.equals(data, noticia.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, texto, data);
    }
}
