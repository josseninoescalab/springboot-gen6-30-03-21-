package com.escalab.mediappbackend.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICRUD<E> {

    E findById(Integer id) throws Exception;
    List<E> findAll();
    E save(E e);
    E update(E e);
    boolean deleteById(Integer id) throws Exception;

}
