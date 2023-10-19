package com.emblematic.productos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	@Id
	private String id;
	private String nombre;
	private String descripcion;
	private double precioUnitario;
	private Integer stock;
	@DBRef
	private Categoria categoria;

}
