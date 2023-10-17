package com.emblematic.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emblematic.productos.entity.Categoria;
import com.emblematic.productos.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> buscarPorNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre);
	}

	@Override
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria guardar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void eliminar(String id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<Categoria> buscarPorId(String idCategoria) {
		return categoriaRepository.findById(idCategoria);
	}

}
