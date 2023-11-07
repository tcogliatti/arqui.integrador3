package tudai.tp3arqui.dto.responses;


import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import tudai.tp3arqui.model.Carrera;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private final Long idCarrera;
    private final String nombre;
    private final int duracion;

    public CarreraResponseDTO(Carrera c){
        this.idCarrera = c.getIdCarrera();
        this.nombre = c.getNombre();
        this.duracion = c.getDuracion();
    }

}
