package com.emblematic.productos.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emblematic.productos.entity.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String>{
	
	Optional<Producto> findByNombre(String nombre);

}
