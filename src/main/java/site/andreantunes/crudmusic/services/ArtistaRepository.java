package site.andreantunes.crudmusic.services;

import org.springframework.data.jpa.repository.JpaRepository;
import site.andreantunes.crudmusic.models.Artista;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
}
