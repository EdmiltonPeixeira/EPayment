package com.edmilton.EPayment.service;

import com.edmilton.EPayment.dto.AtualizaPagamentoDto;
import com.edmilton.EPayment.model.MetodoPagamento;
import com.edmilton.EPayment.model.StatusPagamento;
import com.edmilton.EPayment.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.edmilton.EPayment.model.Pagamento;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
        pagamento.setStatus(StatusPagamento.PENDENTE_DE_PROCESSAMENTO);
        pagamentoRepository.save(pagamento);
        return ResponseEntity.ok().body("Pagamento registrado com sucesso!");
    }

    public ResponseEntity<String> alterarPagamento(AtualizaPagamentoDto atualizaPagamentoDto) throws IllegalArgumentException{
        String mensagem = "";
        try {
            StatusPagamento novoStatus = StatusPagamento.valueOf(atualizaPagamentoDto.getStatus());
            Pagamento pagamento = pagamentoRepository.findPagamentoById(atualizaPagamentoDto.getId());
            if(pagamento.getStatus().equals(StatusPagamento.PROCESSADO_COM_SUCESSO)){
                mensagem = "Pagamentos com status PROCESSADO COM SUCESSO não podem ser alterados.";
            } else if(pagamento.getStatus().equals(StatusPagamento.PROCESSADO_COM_FALHA)){
                if(novoStatus.equals(StatusPagamento.PROCESSADO_COM_SUCESSO)) {
                    mensagem = "Pagamentos com status PROCESSADO COM FALHA podem ser " +
                            "alterados apenas para PENDENTE DE PROCESSAMENTO";
                } else if (novoStatus.equals(pagamento.getStatus())){
                    mensagem = "Pagamento não alterado porque o novo status é igual ao atual.";
                } else {
                    pagamento.setStatus(novoStatus);
                    pagamentoRepository.save(pagamento);
                    mensagem = "Pagamento alterado com sucesso!";
                }
            } else if(pagamento.getStatus().equals(StatusPagamento.PENDENTE_DE_PROCESSAMENTO)
                && Arrays.stream(StatusPagamento.values()).toList().contains(novoStatus)){
                if (novoStatus.equals(pagamento.getStatus())) {
                    mensagem = "Pagamento não alterado porque o novo status é igual ao atual.";
                } else {
                    pagamento.setStatus(novoStatus);
                    pagamentoRepository.save(pagamento);
                    mensagem = "Pagamento alterado com sucesso!";
                }
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(mensagem);
    }
}
