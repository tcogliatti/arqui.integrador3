package tudai.tp3arqui.dto.responses;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tudai.tp3arqui.model.Estudiante;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {
    private final int lu;
    private final Long dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String genero;
    private final String direccion;

    public EstudianteResponseDTO(Estudiante estudiante){
        this.lu = estudiante.getLu();
        this.dni = estudiante.getDni();
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.direccion = estudiante.getDireccion();
    }
}
