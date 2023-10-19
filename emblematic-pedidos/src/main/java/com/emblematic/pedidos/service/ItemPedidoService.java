package com.emblematic.pedidos.service;

import com.emblematic.pedidos.entity.ItemPedido;

public interface ItemPedidoService {
	
	ItemPedido guardarItemPedido(ItemPedido itemPedido);
	void eliminarItemPedido(Integer idItemPedido);
	void marcarComoEntregado(Integer idItemPedido);

}
