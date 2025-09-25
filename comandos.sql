create table autor(
    id uuid not null primary key,
    nome varchar(255) not null,
    data_nascimento date not null,
    nacionalidade varchar(100) not null,
    data_cadastro timestamp not null default current_timestamp,
    data_atualizacao timestamp not null default current_timestamp,
    id_usuario uuid
    
);
create table livro (
    id uuid not null primary key,
    titulo varchar(255) not null,
    isbn varchar(20) not null unique,
    ano_publicacao int not null,
    editora varchar(100) not null,
    data_publicacao date not null,
    genero varchar(50) not null,
    preco numeric(18,2),
    data_cadastro timestamp not null default current_timestamp,
    data_atualizacao timestamp not null default current_timestamp,
    id_usuario uuid,
    id_autor uuid not null references autor(id),
    constraint fk_livro_autor foreign key (id_autor) references autor(id),
    constraint chk_genero check (genero in ('FICCAO', 'FANTASIA', 'MISTERIO', 'ROMANCE', 'BIOGRAFIA', 'HISTORIA', 'CIENCIA', 'TECNOLOGIA', 'AUTOAJUDA', 'SAUDE'))
);