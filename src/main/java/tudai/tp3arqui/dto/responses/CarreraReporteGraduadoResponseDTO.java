package tudai.tp3arqui.dto.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraReporteGraduadoResponseDTO {

    private final String nombre;
    private final int anio;
    private final int graduados;
}
