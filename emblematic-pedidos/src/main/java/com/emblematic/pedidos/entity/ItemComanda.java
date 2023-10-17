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
@Table(name = "items_comanda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemComanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer cantidad;
	private String idProducto;
	private boolean entregado;
	@ManyToOne
	private Comanda comanda;

}
