package tudai.tp3arqui.dto.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarreraReporteResponseDTO {

    private final String nombre;
    private final int anio;
    private int inscriptos;
    private final int graduados;

    public CarreraReporteResponseDTO(String nombre, int anio, int inscriptos, int graduados) {
        this.nombre = nombre;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }
}
