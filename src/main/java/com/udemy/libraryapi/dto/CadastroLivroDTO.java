package com.udemy.libraryapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.ISBN;

import com.udemy.libraryapi.model.GeneroLivro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CadastroLivroDTO(
                @NotBlank(message = "ISBN é obrigatório") 
                @ISBN(type = ISBN.Type.ISBN_13, message = "ISBN inválido")
                String isbn,
                @NotBlank(message = "Título é obrigatório") String titulo,
                @NotNull(message = "Data de publicação é obrigatória")
                @Past(message = "Data de publicação deve ser uma data passada") 
                LocalDate dataPublicacao,
                GeneroLivro genero,
                BigDecimal preco, @NotNull(message = "ID do autor é obrigatório") UUID idAutor) {
}
