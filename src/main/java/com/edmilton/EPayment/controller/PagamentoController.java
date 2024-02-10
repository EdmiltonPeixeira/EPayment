package com.edmilton.EPayment.controller;

import com.edmilton.EPayment.model.Pagamento;
import com.edmilton.EPayment.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listar(){
        return pagamentoService.listarPagamentos();
    }
}
