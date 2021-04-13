package com.escalab.mediappbackend.service;

import com.escalab.mediappbackend.model.Menu;

import java.util.List;

public interface MenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
