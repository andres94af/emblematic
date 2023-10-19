package com.emblematic.pedidos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDao {
	
	private Integer cantidad;
	private String idProducto;
	private double precioUnitario;

}
