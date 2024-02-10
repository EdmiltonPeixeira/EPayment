package com.edmilton.EPayment.repository;

import com.edmilton.EPayment.model.Pagamento;
import com.edmilton.EPayment.model.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    Pagamento findPagamentoById(Integer idPagamento);
    List<Pagamento> findPagamentosByCodigoDebitoAndCpfCnpjPagadorAndStatus(Integer codigoDebito, String cpfCnpjPagador, StatusPagamento status);

    List<Pagamento> findPagamentosByCodigoDebito(Integer codigoDebito);

    List<Pagamento> findPagamentosByCpfCnpjPagador(String cpfCnpjPagador);

    List<Pagamento> findPagamentosByStatus(StatusPagamento status);

    List<Pagamento> findPagamentosByCodigoDebitoAndCpfCnpjPagador(Integer codigoDebito, String cpfCnpjPagador);

    List<Pagamento> findPagamentosByCodigoDebitoAndStatus(Integer codigoDebito, StatusPagamento status);

    List<Pagamento> findPagamentosByCpfCnpjPagadorAndStatus(String cpfCnpjPagador, StatusPagamento status);
}
