create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create table tb_cliente (
	id bigint,
	nome varchar(50) not null,
	cpf bigint not null,
	tel bigint not null,
	endereco varchar(50) not null,
	numero bigint not null,
	cidade varchar(50) not null,
	estado varchar(50) not null,
	constraint pk_id_cliente primary key(id)
);

select * from tb_cliente;
drop table tb_cliente;

insert into tb_cliente values('Lucas', 102030);
ALTER TABLE tb_cliente ALTER COLUMN cpf SET DEFAULT '12345678901'
ALTER TABLE tb_cliente ALTER COLUMN tel SET DEFAULT '21972162157'
ALTER TABLE tb_cliente ALTER COLUMN endereco SET DEFAULT 'Rua Sapucai'
ALTER TABLE tb_cliente ALTER COLUMN nome SET DEFAULT 'Lucas Santiago'
ALTER TABLE tb_cliente ALTER COLUMN numero SET DEFAULT '33054864'
ALTER TABLE tb_cliente ALTER COLUMN cidade SET DEFAULT 'Rio de Janeiro'
ALTER TABLE tb_cliente ALTER COLUMN estado SET DEFAULT 'RJ'