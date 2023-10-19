package com.emblematic.pedidos.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emblematic.pedidos.entity.Pedido;
import com.emblematic.pedidos.repository.PedidoRepository;
import com.emblematic.pedidos.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public Optional<Pedido> buscarPorId(Integer idPedido) {
		return pedidoRepository.findById(idPedido);
	}

	@Override
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
	    establecerNumeroFactura(pedido);
	    pedido.setFechaPedido(LocalDate.now());
	    return pedidoRepository.save(pedido);
	}


	@Override
	public void pagarPedido(Integer idPedido) {
		Optional<Pedido> pedidoOPT = pedidoRepository.findById(idPedido);
		if (pedidoOPT.isPresent()) {
			Pedido pedido = pedidoOPT.get();
			pedido.setPagado(true);
			pedidoRepository.save(pedido);
		}
	}

	private void establecerNumeroFactura(Pedido pedido) {
		Pedido ultimoPedido = pedidoRepository.findFirstByOrderByIdDesc().orElse(null);
		String numeroFacturaBase = "A 001-%04d";
		if (ultimoPedido != null) {
			int idPedido = ultimoPedido.getId() + 1;
			pedido.setNumeroFactura(String.format(numeroFacturaBase, idPedido));
		} else {
			pedido.setNumeroFactura(String.format(numeroFacturaBase, 1));
		}
	}
}
