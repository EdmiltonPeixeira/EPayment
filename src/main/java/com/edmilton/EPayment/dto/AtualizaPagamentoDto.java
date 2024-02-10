package com.edmilton.EPayment.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtualizaPagamentoDto {
    Integer id;
    String status;
}
