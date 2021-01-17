package br.com.fabio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabio.api.dominio.Filme;

public interface FilmeRepositorio extends JpaRepository<Filme, Integer> {

}
