package com.emblematic.productos.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emblematic.productos.entity.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String>{
	
	Optional<Categoria> findByNombre(String nombre);

}
