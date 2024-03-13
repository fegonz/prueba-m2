package com.m3.informatica.api.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.m3.informatica.api.model.dao.ILenguajeDao;
import com.m3.informatica.api.model.entities.Lenguaje;

@Service
public class LenguajeServiceImpl implements ILenguajeService{
	
	@Autowired
	private ILenguajeDao lenguajeDao;


	@Override
	public Lenguaje findById(Long id) {
		// TODO Auto-generated method stub
		return lenguajeDao.findById(id).orElse(null);
	}

	@Override
	public Lenguaje save(Lenguaje lenguaje) {
		// TODO Auto-generated method stub
		return lenguajeDao.save(lenguaje);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lenguajeDao.deleteById(id);
		
	}
	
	

}
