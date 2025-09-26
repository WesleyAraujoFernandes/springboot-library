package com.udemy.libraryapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.libraryapi.service.LivroService;

import lombok.RequiredArgsConstructor;

@RequestMapping("livros")
@RestController
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;
}
