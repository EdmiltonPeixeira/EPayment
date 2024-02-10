package com.edmilton.EPayment.service;

import com.edmilton.EPayment.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edmilton.EPayment.model.Pagamento;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public List<Pagamento> listarTodosPagamentos(){
        return pagamentoRepository.findAll();
    }

    public void cadastrarPagamento(Pagamento pagamento){
        pagamentoRepository.save(pagamento);
    }
}
