package cl.marco.literalura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;

    public Libro(){}

    public Libro(LibroDTO libroDTO) {
        this.titulo = libroDTO.titulo();
        if (libroDTO.idiomas() != null && !libroDTO.idiomas().isEmpty()) {
        // Si ambas condiciones son ciertas, tomamos el primer idioma.
        this.idioma = libroDTO.idiomas().get(0);
    } else {
        // Si la lista es nula o está vacía, asignamos un valor por defecto.
        this.idioma = "desconocido";
    }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return String.format(
            titulo, autor, idioma
        );
    }


}
