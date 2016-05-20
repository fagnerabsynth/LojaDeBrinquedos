# Loja De Brinquedos
 
 Projeto do Prof. Almir com java Web...
 
 Faça a query no mysql
 
 
create database projetoalmir;<br />
create table projetoalmir.brinquedos (
codigo int auto_increment primary key not null, 
descricao varchar(250) not null, 
categoria varchar(250) not null,
marca varchar(250) not null,
imagem longtext not null,
preco decimal(10,2) not null,
detalhe longtext not null );
CREATE USER 'projetoalmir'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON `projetoalmir` . * TO 'projetoalmir'@'localhost' WITH GRANT OPTION ;
FLUSH PRIVILEGES;
