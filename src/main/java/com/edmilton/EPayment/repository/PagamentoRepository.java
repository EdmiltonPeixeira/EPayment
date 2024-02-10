package com.edmilton.EPayment.repository;

import com.edmilton.EPayment.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    Pagamento findPagamentoById(Integer idPagamento);
}
