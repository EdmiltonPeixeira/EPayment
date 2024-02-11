package com.edmilton.EPayment.controller;

import com.edmilton.EPayment.dto.AtualizaPagamentoDto;
import com.edmilton.EPayment.model.Pagamento;
import com.edmilton.EPayment.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epayment/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Exibe todos os pagamentos cadastrados.")
    public List<Pagamento> listarTodos(){
        return pagamentoService.listarTodosPagamentos();
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra um novo pagamento.")
    public ResponseEntity<String> cadastrar(@RequestBody Pagamento pagamento){
        return pagamentoService.cadastrarPagamento(pagamento);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Altera o status de um pagamento.")
    public ResponseEntity<String> atualizarStatus(@RequestBody AtualizaPagamentoDto atualizaPagamentoDto){
        return pagamentoService.alterarPagamento(atualizaPagamentoDto);
    }

    @GetMapping("/filtros")
    @Operation(summary = "Exibe os pagamentos cadastrados a partir dos filtros: " +
            "codigoDebito, cpfCnpjPagador e status.")
    public List<Pagamento> listarComFiltros(
            @RequestParam(name = "codigoDebito", required = false) Integer codigoDebito,
            @RequestParam(name = "cpfCnpjPagador", required = false) String cpfCnpjPagador,
            @RequestParam(name = "status", required = false) String status){
        return pagamentoService.buscarPorFiltros(codigoDebito, cpfCnpjPagador, status);
    }

    @DeleteMapping
    @Transactional
    @Operation(summary = "Exclui um pagamento a partir do seu id.")
    public ResponseEntity<String> excluir(@RequestParam(name = "idPagamento", required = false) Integer idPagamento){
        return pagamentoService.excluirPagamento(idPagamento);
    }
}
