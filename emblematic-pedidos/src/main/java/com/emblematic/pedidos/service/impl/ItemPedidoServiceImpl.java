package com.emblematic.pedidos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emblematic.pedidos.entity.ItemPedido;
import com.emblematic.pedidos.repository.ItemPedidoRepository;
import com.emblematic.pedidos.service.ItemPedidoService;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public ItemPedido guardarItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	@Override
	public void eliminarItemPedido(Integer idItemPedido) {
		itemPedidoRepository.deleteById(idItemPedido);
	}

	@Override
	public void marcarComoEntregado(Integer idItemPedido) {
		Optional<ItemPedido> itemOPT = itemPedidoRepository.findById(idItemPedido);
		if (itemOPT.isPresent()) {
			ItemPedido item = itemOPT.get();
			item.setEntregado(true);
			itemPedidoRepository.save(item);
		}
	}

}
