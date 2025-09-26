package com.udemy.libraryapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "livro")
@Entity
@ToString(exclude = "autor")
@EntityListeners(AuditingEntityListener.class)
public class Livro {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "titulo", length = 255, nullable = false)
    private String titulo;
    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    private String isbn;
    @Column(name = "ano_publicacao", nullable = false)
    private int anoPublicacao;
    @Column(name = "editora", length = 100, nullable = false)
    private String editora;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 50, nullable = false)
    private GeneroLivro genero;
    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;
    @CreatedDate
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDate dataCadastro;
    @LastModifiedDate
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;
    @Column(name = "id_usuario")
    private UUID idUsuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;
}
