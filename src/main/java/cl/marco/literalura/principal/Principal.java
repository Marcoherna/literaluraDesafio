package cl.marco.literalura.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.marco.literalura.model.Autor;
import cl.marco.literalura.model.AutorDTO;
import cl.marco.literalura.model.DatosDTO;
import cl.marco.literalura.model.Libro;
import cl.marco.literalura.model.LibroDTO;
import cl.marco.literalura.repository.AutorRepository;
import cl.marco.literalura.repository.LibroRepository;
import cl.marco.literalura.service.ConsumoAPI;

@Component
public class Principal {

    @Autowired
	private ConsumoAPI consumoAPI;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private Scanner teclado = new Scanner(System.in);
    
    public void mostrarMenu() {
        System.out.println("/n----- MENÚ LITERALURA -----");
        System.out.println("""
                1- Buscar libro por título
                2- Listar libros registrados
                3- Listar autores registrados
                4- Listar autores vivos en un determinado año
                5- Listar libros por idioma
                6- Salir
                Elija la opción a través de su número:
                """);
    }

    public void buscarYRegistrarLibro() {
        System.out.println("Introduce el título del libro a buscar: ");
        String titulo = teclado.nextLine();
        DatosDTO datos = consumoAPI.buscarLibroPorTitulo(titulo);

        if (datos != null && !datos.libros().isEmpty()) {
            LibroDTO libroEncontrado = datos.libros().get(0);

            Optional<Libro> libroExistente = libroRepository.findByTituloIgnoreCase(libroEncontrado.titulo());
            
            if (libroExistente.isPresent()) {
                System.out.println("El libro '" + libroExistente.get().getTitulo() + "' ya está registrado.");
                return;            
            }
            
            AutorDTO autorEncontrado = libroEncontrado.autores().get(0);
            Optional<Autor> autorExistente = autorRepository.findByNombreIgnoreCase(autorEncontrado.nombre());
            
            Autor autor;
            if (autorExistente.isPresent()) {
                autor = autorExistente.get();
            } else {
                autor = new Autor(autorEncontrado);
                autorRepository.save(autor);
            }

            Libro nuevoLibro = new Libro(libroEncontrado);
            nuevoLibro.setAutor(autor);
            libroRepository.save(nuevoLibro);
            System.out.println("Libro registrado con éxito.");


        } else {
            System.out.println("No se encontraron libros con ese título.");
        }
    

    }

    public void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("Libros registrados:");
            libros.forEach(System.out::println);
            
        }
    }

    public void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            System.out.println("Autores registrados:");
            autores.forEach(System.out::println);
        }
    }

    public void listarAutoresVivos() {
        System.out.println("Introduce un año para listar autores vivos: ");
        try {
            int anio = Integer.parseInt(teclado.nextLine());
            List<Autor> autoresVivos = autorRepository.findAutoresVivosEnAnio(anio);
            
            if (autoresVivos.isEmpty()) {
                System.out.println("No hay autores vivos en el año " + anio + ".");                
            } else {
                System.out.println("Autores vivos en el año " + anio + ":");
                autoresVivos.forEach(autor ->
                    System.out.println(
                        "Nombre: " + autor.getNombre()
                    )
                );
            }


        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un año válido.");
        }
    }

    public void listarLibrosPorIdioma() {
        System.out.println("Introduce un idioma para buscar libros (ej: 'es' para español, 'en' para inglés, etc.): ");
        String idioma = teclado.nextLine().toLowerCase();
        
        List<Libro> librosPorIdioma = libroRepository.findByIdioma(idioma);

        if (librosPorIdioma.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma '" + idioma + "'.");
        } else {
            System.out.println("Libros en el idioma '" + idioma + "':");
            librosPorIdioma.forEach(System.out::println);
        }

            
    }




}
