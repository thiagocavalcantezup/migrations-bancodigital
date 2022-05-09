package com.zupedu.bancodigital.conta;

import java.net.URI;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.zupedu.bancodigital.pagamento.Pagamento;
import com.zupedu.bancodigital.pagamento.PagamentoRequest;
import com.zupedu.bancodigital.pagamento.PagamentoResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ContaController.BASE_URI)
public class ContaController {

    public final static String BASE_URI = "/contas";
    public final static String PAGAMENTO_URI = "/pagamentos";

    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ContaRequest contaRequest,
                                    UriComponentsBuilder ucb) {
        Conta conta = contaRepository.save(contaRequest.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}" + PAGAMENTO_URI)
    public ResponseEntity<?> indexPagamentos(@PathVariable Long id) {
        Conta conta = contaRepository.findById(id)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe uma conta com o id informado."
                                         )
                                     );

        return ResponseEntity.ok(
            conta.getPagamentos().stream().map(PagamentoResponse::new).collect(Collectors.toSet())
        );
    }

    @Transactional
    @PostMapping("/{id}" + PAGAMENTO_URI)
    public ResponseEntity<?> createPagamento(@PathVariable Long id,
                                             @RequestBody @Valid PagamentoRequest pagamentoRequest,
                                             UriComponentsBuilder ucb) {
        Conta conta = contaRepository.findById(id)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe uma conta com o id informado."
                                         )
                                     );

        Pagamento pagamento = pagamentoRequest.toModel();
        conta.adicionar(pagamento);
        contaRepository.flush();

        URI location = ucb.path(BASE_URI + "/{id}" + PAGAMENTO_URI + "/{pagamentoId}")
                          .buildAndExpand(id, pagamento.getId())
                          .toUri();

        return ResponseEntity.created(location).build();
    }

}
