package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Signos;
import com.mitocode.service.ISignoService;

@RestController
@RequestMapping("/signos")
public class SignoController {

	@Autowired
	private ISignoService service;

	@GetMapping
	public ResponseEntity<List<Signos>> listar() {
		List<Signos> signosVitales = service.listar();
		return new ResponseEntity<List<Signos>>(signosVitales, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Signos sig) {
		Signos signos = service.registrar(sig);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(signos.getIdSigno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object>  modificar(@Valid @RequestBody Signos sig) {
		service.modificar(sig);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Signos> leerPorId(@PathVariable("id") Integer id) {
		Signos obj = service.leerPorId(id);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Signos>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  eliminar(@PathVariable("id") Integer id) {
		Signos obj = service.leerPorId(id);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

}
