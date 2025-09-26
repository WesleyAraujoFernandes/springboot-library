package com.udemy.libraryapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.udemy.libraryapi.model.GeneroLivro;

public record CadastroLivroDTO(String isbn, String titulo, LocalDate dataPublicacao, GeneroLivro genero,
        BigDecimal preco, UUID idAutor) {

}
