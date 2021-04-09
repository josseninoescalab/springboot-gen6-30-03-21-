package com.escalab.mediappbackend.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDI<E> {

    ResponseEntity<E> findById(Integer id);
    List<E> findAll();
    ResponseEntity<E> save(E e);
    E update(E e);
    void deleteById(Integer id);

}
