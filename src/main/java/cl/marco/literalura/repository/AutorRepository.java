package cl.marco.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.marco.literalura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    Optional<Autor> findByNombreIgnoreCase(String nombre);
    
    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :anio AND (a.anioFallecimiento IS NULL OR a.anioFallecimiento >= :anio)")
    List<Autor> findAutoresVivosEnAnio(int anio);
}
