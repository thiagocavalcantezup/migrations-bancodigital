package com.zupedu.bancodigital.conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zupedu.bancodigital.pagamento.Pagamento;

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

    @OneToMany(mappedBy = "conta", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Pagamento> pagamentos = new HashSet<>();

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

    public void adicionar(Pagamento pagamento) {
        pagamento.setConta(this);
        pagamentos.add(pagamento);
    }

    public Long getId() {
        return id;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

}
