package com.zupedu.bancodigital.conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContaRequest {

    @NotBlank
    private String documentoTitular;

    @NotBlank
    private String nomeTitular;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime abertura;

    @NotNull
    @PositiveOrZero
    private Integer agencia;

    @NotNull
    @PositiveOrZero
    private Long numero;

    @NotNull
    @PositiveOrZero
    private BigDecimal saldo;

    public ContaRequest() {}

    public ContaRequest(@NotBlank String documentoTitular, @NotBlank String nomeTitular,
                        @NotNull @PastOrPresent LocalDateTime abertura,
                        @NotNull @PositiveOrZero Integer agencia,
                        @NotNull @PositiveOrZero Long numero,
                        @NotNull @PositiveOrZero BigDecimal saldo) {
        this.documentoTitular = documentoTitular;
        this.nomeTitular = nomeTitular;
        this.abertura = abertura;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta toModel() {
        return new Conta(documentoTitular, nomeTitular, abertura, agencia, numero, saldo);
    }

    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
