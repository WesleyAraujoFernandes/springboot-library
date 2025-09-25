package com.udemy.libraryapi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udemy.libraryapi.model.Autor;
import com.udemy.libraryapi.model.GeneroLivro;
import com.udemy.libraryapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    List<Livro> findByAutorId(UUID autorId);
    List<Livro> findByAutor(Autor autor);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByGenero(GeneroLivro genero);
    List<Livro> findByAnoPublicacao(int anoPublicacao);
    List<Livro> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    List<Livro> findByTituloAndPrecoBetween(String titulo, java.math.BigDecimal precoInicial, java.math.BigDecimal precoFinal);
    List<Livro> findByPrecoBetween(java.math.BigDecimal precoInicial, java.math.BigDecimal precoFinal);
    List<Livro> findByTituloOrIsbnOrderByTitulo(String titulo, String isbn);
    List<Livro> findByDataPublicacaoBetween(LocalDate dataInicio, LocalDate dataFim);
    // JPQL -> referencia a classe e atributos, não a tabela e colunas do banco
    // select l.* from livro l order by l.titulo asc, l.preco desc
    @Query("SELECT l FROM Livro l ORDER BY l.titulo ASC, l.preco DESC")
    List<Livro> listarTodosOrdenadosPorTituloAndPreco();
    /**
     * select a.* from livro l
     * join autor a on l.id_autor = a.id
     */
    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();
}
