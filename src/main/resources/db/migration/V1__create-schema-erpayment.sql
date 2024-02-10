CREATE SCHEMA IF NOT EXISTS erpayment;

create table pagamentos (
    id int not null auto_increment,
    codigo_debito int not null,
    cpf_cnpj_pagador varchar(30) not null,
    metodo_pagamento varchar(30) not null,
    numero_cartao varchar(30) not null,
    valor_pagamento number not null,

    primary key(id)
);