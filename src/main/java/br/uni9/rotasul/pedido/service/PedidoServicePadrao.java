package br.uni9.rotasul.pedido.service;

import br.uni9.rotasul.pedido.domain.Pedido;
import br.uni9.rotasul.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServicePadrao implements PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoServicePadrao(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        if (pedido.getDataCriacao() == null) {
            pedido.setDataCriacao(LocalDateTime.now());
        }
        if (pedido.getStatus() == null) {
            pedido.setStatus("CRIADO");
        }
        return pedidoRepository.salvar(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.buscarTodos();
    }
}