package com.zupedu.bancodigital.conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentoTitular;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false)
    private LocalDateTime abertura;

    @Column(nullable = false)
    private int agencia;

    @Column(nullable = false)
    private long numero;

    @Column(nullable = false)
    private BigDecimal saldo;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Conta() {}

    public Conta(String documentoTitular, String nomeTitular, LocalDateTime abertura, int agencia,
                 long numero, BigDecimal saldo) {
        this.documentoTitular = documentoTitular;
        this.nomeTitular = nomeTitular;
        this.abertura = abertura;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

}
