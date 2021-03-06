package com.escalab.mediappbackend.controller;

import com.escalab.mediappbackend.model.Menu;
import com.escalab.mediappbackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.findAll();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
}
