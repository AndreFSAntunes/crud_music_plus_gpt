package site.andreantunes.crudmusic.services;

import org.springframework.data.jpa.repository.JpaRepository;
import site.andreantunes.crudmusic.models.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
