package com.zupedu.bancodigital.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.zupedu.bancodigital.conta.Conta;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeCobranca tipoCobranca;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToMany(mappedBy = "produtos")
    private Set<Conta> contas = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Produto() {}

    public Produto(String nome, BigDecimal valor, TipoDeCobranca tipoCobranca) {
        this.nome = nome;
        this.valor = valor;
        this.tipoCobranca = tipoCobranca;
    }

    public Long getId() {
        return id;
    }

    public Set<Conta> getContas() {
        return contas;
    }

}
