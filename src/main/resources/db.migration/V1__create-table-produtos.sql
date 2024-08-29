CREATE TABLE produtos (

    id bigint not null auto_increment,
    nome varchar(255) not null,
    codigo bigint (7) not null,
    descricao varchar(50),
    preco decimal(10, 2) not null,

    primary key (id)
);