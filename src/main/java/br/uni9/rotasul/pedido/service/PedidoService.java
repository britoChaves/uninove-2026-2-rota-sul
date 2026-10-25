package br.uni9.rotasul.pedido.service;

import br.uni9.rotasul.pedido.domain.Pedido;
import java.util.List;

public interface PedidoService {
    Pedido criarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
}