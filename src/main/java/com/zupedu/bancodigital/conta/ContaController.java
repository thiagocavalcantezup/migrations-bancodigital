package com.zupedu.bancodigital.conta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ContaController.BASE_URI)
public class ContaController {

    public final static String BASE_URI = "/contas";

    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ContaRequest contaRequest,
                                    UriComponentsBuilder ucb) {
        Conta conta = contaRepository.save(contaRequest.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
