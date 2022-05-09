package com.zupedu.bancodigital.pagamento;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class PagamentoRequest {

    @NotBlank
    private String codigoDeBarras;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotBlank
    private String codigoDeConfirmacao;

    public PagamentoRequest() {}

    public PagamentoRequest(@NotBlank String codigoDeBarras,
                            @NotNull @PositiveOrZero BigDecimal valor,
                            @NotBlank String codigoDeConfirmacao) {
        this.codigoDeBarras = codigoDeBarras;
        this.valor = valor;
        this.codigoDeConfirmacao = codigoDeConfirmacao;
    }

    public Pagamento toModel() {
        return new Pagamento(codigoDeBarras, valor, codigoDeConfirmacao);
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
