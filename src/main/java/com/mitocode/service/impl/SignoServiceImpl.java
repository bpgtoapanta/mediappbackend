package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Signos;
import com.mitocode.repo.ISignoRepo;
import com.mitocode.service.ISignoService;

@Service
public class SignoServiceImpl implements ISignoService{
	
	@Autowired
	private ISignoRepo repo;

	@Override
	public Signos registrar(Signos t) {
		return repo.save(t);
	}

	@Override
	public Signos modificar(Signos t) {
		return repo.save(t);
	}

	@Override
	public Signos leerPorId(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public List<Signos> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.delete(id);
	}

}
