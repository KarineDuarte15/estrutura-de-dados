create database cadastro;
use cadastro;
create table cadastro_completo(
id int auto_increment not null,
nome varchar(100),
cpf varchar(100),
rg varchar(100),
nascimento date ,
sexo varchar(100),
nome_da_mae varchar(100),
nome_do_pai varchar(100),
email varchar(100),
telefone varchar(50),
cep varchar(100),
endereço varchar(100),
bairro varchar(100),
cidade varchar(100),
país varchar(100),
primary key(id)
);
insert into cadastro_completo(nome,cpf,rg,nascimento,sexo,nome_da_mae,nome_do_pai,email,telefone,cep,endereço,bairro,cidade,país) values('Karine Duarte ','62357104376 ','20160544680 ','2002-06-28 ','Feminino ','Francisca Duarte ','Francisco Ferreira ','kaahduarte15@gmail.com ','8599676526 ','60544-680 ','conj tatumunde quadra b bl 07 apto 02 ','siqueira ','Fortaleza ','Brasil ')
,('francisca Duarte ','41057481300 ','20160544452 ','1963-10-08 ','Feminino ','raimunda Duarte ','Francisco bento ','franduarte@gmail.com ','8599675426 ','60544-680 ','conj tatumunde quadra b bl 07 apto 02 ','siqueira ','Fortaleza ','Brasil ');
select * from cadastro_completo;
drop table cadastro_completo;
Delete  from cadastro_completo where id = 2;