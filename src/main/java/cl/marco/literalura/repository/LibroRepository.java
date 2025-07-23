package cl.marco.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.marco.literalura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    Optional<Libro> findByTituloIgnoreCase(String titulo);

    List<Libro> findByIdioma(String idioma);
    
}
