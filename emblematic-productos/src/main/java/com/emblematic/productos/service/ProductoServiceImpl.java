package com.emblematic.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emblematic.productos.entity.Producto;
import com.emblematic.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Optional<Producto> buscarPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizarStock(Producto producto, Integer stock) {
		Optional<Producto> productoOpt = productoRepository.findByNombre(producto.getNombre());
		if (productoOpt.isPresent()) {
			Producto productoAct = productoOpt.get();
			productoAct.setStock(stock);
			return productoRepository.save(productoAct);
		}
		return null;
	}

	@Override
	public void eliminar(String id) {
		productoRepository.deleteById(id);
	}
	
	
	
}
