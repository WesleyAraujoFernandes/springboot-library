package com.udemy.libraryapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.libraryapi.model.Autor;

@RestController
@RequestMapping("autores")
public class AutorController {
    @PostMapping
    public Object salvar(Autor autor) {
        return autor;
    }
}
