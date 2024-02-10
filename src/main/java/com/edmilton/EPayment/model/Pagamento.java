package com.edmilton.EPayment.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigoDebito;

    private String cpfCnpjPagador;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    private String numeroCartao;

    private BigDecimal valorPagamento;
}
