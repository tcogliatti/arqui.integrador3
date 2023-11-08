package tudai.tp3arqui.dto.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import tudai.tp3arqui.model.Carrera;

@Data
@RequiredArgsConstructor
public class CarreraInscriptosResponseDTO {

    private final Long idCarrera;
    private final String nombre;
    private final int inscriptos;

    public CarreraInscriptosResponseDTO(Carrera c){
        this.idCarrera = c.getIdCarrera();
        this.nombre = c.getNombre();
        this.inscriptos = c.getMatriculados().size();
    }
}
