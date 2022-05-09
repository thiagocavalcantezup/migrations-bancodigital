package com.zupedu.bancodigital.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoResponse {

    private Long id;
    private LocalDateTime data;
    private String codigoDeBarras;
    private BigDecimal valor;
    private String codigoDeConfirmacao;

    public PagamentoResponse() {}

    public PagamentoResponse(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.data = pagamento.getData();
        this.codigoDeBarras = pagamento.getCodigoDeBarras();
        this.valor = pagamento.getValor();
        this.codigoDeConfirmacao = pagamento.getCodigoDeConfirmacao();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCodigoDeConfirmacao() {
        return codigoDeConfirmacao;
    }

}
