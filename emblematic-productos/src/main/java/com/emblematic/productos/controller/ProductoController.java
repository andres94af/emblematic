package com.emblematic.productos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emblematic.productos.entity.Categoria;
import com.emblematic.productos.entity.Producto;
import com.emblematic.productos.service.CategoriaService;
import com.emblematic.productos.service.ProductoService;

@RestController
@RequestMapping("/emblematic/productos")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos() {
		List<Producto> productos = productoService.listar();
		return ResponseEntity.ok(productos);
	}
	
	@PostMapping("/{idCategoria}")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto, @PathVariable String idCategoria) {
		Optional<Categoria> categoriaOpt = categoriaService.buscarPorId(idCategoria);
		if (categoriaOpt.isPresent()) {
			producto.setCategoria(categoriaOpt.get());
			return ResponseEntity.ok(productoService.guardar(producto));
		}
		return ResponseEntity.unprocessableEntity().build();
	}

}
