package com.edmilton.EPayment.controller;

import com.edmilton.EPayment.dto.AtualizaPagamentoDto;
import com.edmilton.EPayment.model.Pagamento;
import com.edmilton.EPayment.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epayment/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listarTodos(){
        return pagamentoService.listarTodosPagamentos();
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Pagamento pagamento){
        return pagamentoService.cadastrarPagamento(pagamento);
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@RequestBody AtualizaPagamentoDto atualizaPagamentoDto){
        return pagamentoService.alterarPagamento(atualizaPagamentoDto);
    }

    @GetMapping("/filtros")
    public List<Pagamento> listarComFiltros(
            @RequestParam(name = "codigoDebito", required = false) Integer codigoDebito,
            @RequestParam(name = "cpfCnpjPagador", required = false) String cpfCnpjPagador,
            @RequestParam(name = "status", required = false) String status){
        return pagamentoService.buscarPorFiltros(codigoDebito, cpfCnpjPagador, status);
    }
}
