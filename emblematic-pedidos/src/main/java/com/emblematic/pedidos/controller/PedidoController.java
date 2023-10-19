package com.emblematic.pedidos.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emblematic.pedidos.entity.ItemPedido;
import com.emblematic.pedidos.entity.ItemPedidoDao;
import com.emblematic.pedidos.entity.Pedido;
import com.emblematic.pedidos.service.ItemPedidoService;
import com.emblematic.pedidos.service.PedidoService;

@RestController
@RequestMapping("/emblematic/pedidos")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@Autowired
	ItemPedidoService itemPedidoService;

	private List<ItemPedido> itemsPedido = new ArrayList<>();

	private Pedido pedido = new Pedido();

	@GetMapping("")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		return ResponseEntity.ok(pedidos);
	}

	/**
	 * @return Retorna listado actual de items agregados
	 */
	@GetMapping("/items")
	public ResponseEntity<List<ItemPedido>> listarItemsActuales() {
		return ResponseEntity.ok(itemsPedido);
	}

	/**
	 * Agrega un item al pedido en curso.
	 * 
	 * @param itemDAO
	 */
	@PostMapping("/agregarItem")
	public void agregarItem(@RequestBody ItemPedidoDao itemDAO) {
		ItemPedido nuevoItem = new ItemPedido();
		nuevoItem.setIdProducto(itemDAO.getIdProducto());
		nuevoItem.setCantidad(itemDAO.getCantidad());
		nuevoItem.setPrecioUnitario(itemDAO.getPrecioUnitario());
		nuevoItem.setPrecioTotal(itemDAO.getPrecioUnitario() * itemDAO.getCantidad());
		itemsPedido.add(nuevoItem);
	}

	/**
	 * Crea nuevo pedido a partir del listado actual de items y lo asigna a la mesa
	 * que recibe como parametro en numeroMesa.
	 * 
	 * @param numeroMesa
	 * @return Retorna el pedido guardado en la base de datos
	 */
	@PostMapping("/crearPedido/{numeroMesa}")
	public ResponseEntity<Pedido> guardarPedido(@PathVariable Integer numeroMesa) {
		pedido.setNumeroMesa(numeroMesa);
		double totalPedido = itemsPedido.stream().mapToDouble(item -> item.getPrecioTotal()).sum();
		pedido.setPrecioFinalNeto(totalPedido);
		Pedido pedidoGuardado = pedidoService.guardarPedido(pedido);
		for (ItemPedido itemPedido : itemsPedido) {
			itemPedido.setPedido(pedidoGuardado);
			itemPedidoService.guardarItemPedido(itemPedido);
		}
		pedido = new Pedido();
		itemsPedido = new ArrayList<>();
		return ResponseEntity.ok(pedidoGuardado);
	}

}
