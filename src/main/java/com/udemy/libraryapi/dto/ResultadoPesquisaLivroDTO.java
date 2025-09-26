package com.udemy.libraryapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.udemy.libraryapi.model.GeneroLivro;

public record ResultadoPesquisaLivroDTO(UUID id, String isbn, String titulo, LocalDate dataPublicacao, GeneroLivro genero,
                BigDecimal preco, AutorDTO autorDTO) {

}
