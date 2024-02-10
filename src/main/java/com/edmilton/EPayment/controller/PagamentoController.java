package com.edmilton.EPayment.controller;

import com.edmilton.EPayment.model.Pagamento;
import com.edmilton.EPayment.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/erpayment/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listarTodos(){
        return pagamentoService.listarTodosPagamentos();
    }


    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Pagamento pagamento){
        return pagamentoService.cadastrarPagamento(pagamento);
    }
}
