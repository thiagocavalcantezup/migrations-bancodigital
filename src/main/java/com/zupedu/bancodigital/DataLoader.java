package com.zupedu.bancodigital;

import java.math.BigDecimal;

import com.zupedu.bancodigital.produto.Produto;
import com.zupedu.bancodigital.produto.ProdutoRepository;
import com.zupedu.bancodigital.produto.TipoDeCobranca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    public DataLoader(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (produtoRepository.count() == 0) {
            load();
        }
    }

    private void load() {
        Produto produto = new Produto(
            "Produto Teste", new BigDecimal("23.44"), TipoDeCobranca.MENSAL
        );

        produtoRepository.save(produto);
    }

}
