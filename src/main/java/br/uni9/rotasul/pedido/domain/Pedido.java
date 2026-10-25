package br.uni9.rotasul.pedido.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private Long id;
    private LocalDateTime dataCriacao;
    private BigDecimal valorTotal;
    private String status;

    public Pedido() {}

    public Pedido(Long id, LocalDateTime dataCriacao, BigDecimal valorTotal, String status) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}