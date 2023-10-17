package com.emblematic.productos.service;

import java.util.List;
import java.util.Optional;

import com.emblematic.productos.entity.Producto;

public interface ProductoService {

	Optional<Producto> buscarPorNombre(String nombre);
	List<Producto> listar();
	Producto guardar(Producto producto);
	Producto actualizarStock(Producto producto, Integer stock);
	void eliminar (String id);
	
	
}
