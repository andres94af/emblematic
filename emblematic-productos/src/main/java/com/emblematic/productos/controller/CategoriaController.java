package com.emblematic.productos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emblematic.productos.entity.Categoria;
import com.emblematic.productos.service.CategoriaService;

@RestController
@RequestMapping("/emblematic/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	/**
	 * 
	 * @return Retorna listado de categorias de productos existentes en la base de datos.
	 */
	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategorias() {
		List<Categoria> categoria = categoriaService.listar();
		return ResponseEntity.ok(categoria);
	}

	/**
	 * Crea un nueva categoria con el nombre que recibe como parametro.
	 * @param nombreCategoria
	 * @return Retorna la nueva categoria creada en la base de datos.
	 */
	@PostMapping("/nueva/{nombreCategoria}")
	public ResponseEntity<Categoria> crearCategoria(@PathVariable String nombreCategoria) {
		Optional<Categoria> categoriaOpt = categoriaService.buscarPorNombre(nombreCategoria);
		if (categoriaOpt.isEmpty()) {
			Categoria categoriaNueva = new Categoria();
			categoriaNueva.setNombre(nombreCategoria);
			return ResponseEntity.ok(categoriaService.guardar(categoriaNueva));
		}
		return ResponseEntity.unprocessableEntity().build();
	}

}
