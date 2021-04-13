package com.escalab.mediappbackend.service.impl;

import com.escalab.mediappbackend.model.Menu;
import com.escalab.mediappbackend.repository.MenuRepository;
import com.escalab.mediappbackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}
	
	@Override
	public Menu update(Menu menu) {
		return menuRepository.save(menu);
	}
	
	@Override
	public boolean deleteById(Integer idMenu) {
		menuRepository.deleteById(idMenu);
		return true;
	}
	
	@Override
	public Menu findById(Integer idMenu) {
		Optional<Menu> op = menuRepository.findById(idMenu);
		return op.isPresent() ? op.get() : new Menu();
	}
	
	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}
	
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		List<Menu> menus = new ArrayList<>();
		menuRepository.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));
			
			menus.add(m);
		});
		return menus;
	}
}
