create table autor (id bigint not null auto_increment, descricao TEXT, email varchar(255), instante_de_cadastro datetime(6), nome varchar(255), primary key (id)) engine=InnoDB
alter table autor add constraint UK_paws1ekxjtf684kw91twtuxh0 unique (email)
