package com.emblematic.pedidos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private int cantidad;
	private double precioUnitario;
	private double precioTotal;
	@ManyToOne
	private Pedido pedido;

}
