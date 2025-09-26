package com.udemy.libraryapi.service;

import org.springframework.stereotype.Service;

import com.udemy.libraryapi.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
}
