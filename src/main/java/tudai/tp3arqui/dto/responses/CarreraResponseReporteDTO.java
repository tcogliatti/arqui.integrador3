package tudai.tp3arqui.dto.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import tudai.tp3arqui.model.Carrera;

@Data
@RequiredArgsConstructor
public class CarreraResponseReporteDTO {

    private final String nombre;
    private final int anio;
    private final int inscriptos;
    private final int graduados;

}
