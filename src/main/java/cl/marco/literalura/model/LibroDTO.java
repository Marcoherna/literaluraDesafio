package cl.marco.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<AutorDTO> autores,
    @JsonAlias("languajes") List<String> idiomas
) {
    
}
