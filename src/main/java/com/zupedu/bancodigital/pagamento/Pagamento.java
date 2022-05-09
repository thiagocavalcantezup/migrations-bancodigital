package com.zupedu.bancodigital.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zupedu.bancodigital.conta.Conta;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Conta conta;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false)
    private String codigoDeBarras;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String codigoDeConfirmacao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Pagamento() {}

    public Pagamento(String codigoDeBarras, BigDecimal valor, String codigoDeConfirmacao) {
        this.codigoDeBarras = codigoDeBarras;
        this.valor = valor;
        this.codigoDeConfirmacao = codigoDeConfirmacao;
    }

    public Long getId() {
        return id;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
