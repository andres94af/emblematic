package com.emblematic.productos.service;

import java.util.List;
import java.util.Optional;

import com.emblematic.productos.entity.Categoria;

public interface CategoriaService {
	
	Optional<Categoria> buscarPorNombre(String nombre);
	Optional<Categoria> buscarPorId(String idCategoria);
	List<Categoria> listar();
	Categoria guardar(Categoria categoria);
	void eliminar (String id);

}
