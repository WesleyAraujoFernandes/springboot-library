package com.udemy.libraryapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.libraryapi.dto.CadastroLivroDTO;
import com.udemy.libraryapi.service.LivroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("livros")
@RestController
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto) {
        try {
            return ResponseEntity.ok(dto);
        } catch (RegistroDuplicadoException e) {
            /* Tratamento de erro para registro duplicado */
            /*
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
            */
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
