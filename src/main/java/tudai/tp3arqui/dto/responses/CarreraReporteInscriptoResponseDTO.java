package tudai.tp3arqui.dto.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraReporteInscriptoResponseDTO {

    private final String nombre;
    private final int anio;
    private final int inscriptos;
}
