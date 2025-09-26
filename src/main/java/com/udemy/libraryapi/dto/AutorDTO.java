package com.udemy.libraryapi.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.udemy.libraryapi.model.Autor;

public record AutorDTO(
    UUID id,
    String nome,
    LocalDate dataNascimento,
    String nacionalidade
) {
    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setId(this.id);
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
