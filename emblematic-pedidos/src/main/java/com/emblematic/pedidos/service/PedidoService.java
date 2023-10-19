package com.emblematic.pedidos.service;

import java.util.List;
import java.util.Optional;

import com.emblematic.pedidos.entity.Pedido;

public interface PedidoService {
	
	Optional<Pedido> buscarPorId(Integer idPedido);
	List<Pedido> listarPedidos();
	Pedido guardarPedido(Pedido pedido);
	void pagarPedido(Integer idPedido);

}
