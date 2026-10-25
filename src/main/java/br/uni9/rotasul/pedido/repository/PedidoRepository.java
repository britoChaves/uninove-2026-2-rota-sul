package br.uni9.rotasul.pedido.repository;

import br.uni9.rotasul.pedido.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido salvar(Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> buscarTodos() {
        return pedidos;
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}