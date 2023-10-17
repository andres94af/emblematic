package com.emblematic.productos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
	
	@Id
	private String id;
	private String nombre;

}
