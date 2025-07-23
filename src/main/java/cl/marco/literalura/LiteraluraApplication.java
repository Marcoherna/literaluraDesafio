package cl.marco.literalura;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.marco.literalura.principal.Principal;


@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
	
	private Scanner teclado = new Scanner(System.in);
	
	@Autowired
	private Principal principal;


	@Override
	public void run(String... args) throws Exception {
		int opcion = 0;
		while (opcion != 6) {
			principal.mostrarMenu();
			try {
				opcion = Integer.parseInt(teclado.nextLine());
				switch (opcion) {
					case 1:
						principal.buscarYRegistrarLibro();
						break;
					case 2:
						principal.listarLibrosRegistrados();
						break;
					case 3:
						principal.listarAutoresRegistrados();
						break;
					case 4:
						principal.listarAutoresVivos();
						break;
					case 5:
						principal.listarLibrosPorIdioma();
						break;
					case 6:
						System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
						break;
					default:
						System.out.println("Opción no válida. Por favor, elija una opción válida.");
				
				}
			} catch (NumberFormatException e) {
				System.out.println("Por favor, ingrese un número válido.");
			}

		}
	}

}
