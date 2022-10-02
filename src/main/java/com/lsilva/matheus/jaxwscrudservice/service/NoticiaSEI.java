package com.lsilva.matheus.jaxwscrudservice.service;

import com.lsilva.matheus.jaxwscrudservice.model.Noticia;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

import java.util.List;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface NoticiaSEI {
    @WebMethod
    Long adicionar(Noticia noticia);

    @WebMethod
    Noticia alterar(Noticia noticia);

    @WebMethod
    boolean apagar(Long id);

    @WebMethod
    List<Noticia> listar();

    @WebMethod
    Noticia ler(Long id);
}
