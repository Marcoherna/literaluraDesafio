package cl.marco.literalura.service;

import cl.marco.literalura.model.DatosDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConsumoAPI {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String URL_BASE = "https://gutendex.com/books";

    public DatosDTO buscarLibroPorTitulo(String titulo) {
        String url = URL_BASE + "?search=" + titulo.replace(" ", "+");
        try {
            String json = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(json, DatosDTO.class);

        } catch (Exception e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
            return null;
        }
    }

}
