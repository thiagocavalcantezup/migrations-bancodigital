package com.zupedu.bancodigital.conta;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class ContaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveriaCadastrarUmPagamento() throws Exception {

        String pagamentoRequestJson = "{\n" + "\"codigoDeBarras\": \"123456789\",\n"
                + "\"valor\": 29.99,\n" + "\"codigoDeConfirmacao\": \"ABC123DEF456\"\n" + "}\n";

        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        mockMvc.perform(
            post(ContaController.BASE_URI + "/1" + ContaController.PAGAMENTO_URI).contentType(
                MediaType.APPLICATION_JSON
            ).content(pagamentoRequestJson)
        )
               .andExpect(status().isCreated())
               .andExpect(
                   header().string(
                       "location",
                       baseUrl + ContaController.BASE_URI + "/1" + ContaController.PAGAMENTO_URI
                               + "/1"
                   )
               );
    }

    @Test
    void deveriaContratarUmProduto() throws Exception {
        mockMvc.perform(patch(ContaController.BASE_URI + "/1" + ContaController.PRODUTO_URI + "/1"))
               .andExpect(status().isNoContent());
    }

}
