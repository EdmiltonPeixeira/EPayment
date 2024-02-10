package com.edmilton.EPayment.service;

import com.edmilton.EPayment.model.MetodoPagamento;
import com.edmilton.EPayment.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.edmilton.EPayment.model.Pagamento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public List<Pagamento> listarTodosPagamentos(){
        return pagamentoRepository.findAll();
    }

    @Transactional
    public ResponseEntity<String> cadastrarPagamento(Pagamento pagamento){
        MetodoPagamento metodoPagamento = pagamento.getMetodoPagamento();
        if((metodoPagamento.equals(MetodoPagamento.CARTAO_DEBITO) || metodoPagamento.equals(MetodoPagamento.CARTAO_CREDITO))){
            if (Objects.isNull(pagamento.getNumeroCartao())) {
                return ResponseEntity.badRequest().body("Não é possível salvar o pagamento sem o número do cartão.");
            }
        } else {
            if(Objects.nonNull(pagamento.getNumeroCartao())){
                return ResponseEntity.badRequest().body("O número do cartão é aceito somente para pagamentos em crédito ou débito.");
            }
        }
        pagamentoRepository.save(pagamento);
        return ResponseEntity.ok().body("Pagamento registrado com sucesso!");
    }
}
