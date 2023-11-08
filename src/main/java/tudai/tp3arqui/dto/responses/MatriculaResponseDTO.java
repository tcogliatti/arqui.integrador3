package tudai.tp3arqui.dto.responses;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.model.Estudiante;
import tudai.tp3arqui.model.Matricula;

@Data
@RequiredArgsConstructor
public class MatriculaResponseDTO {

    private final  Long id;
    private final  CarreraResponseDTO carrera;
    private EstudianteResponseDTO estudiante;
    private final int inscripcion;
    private final  int graduacion;
    private final int antiguedad;

    public  MatriculaResponseDTO(MatriculaResponseDTO matriculacion){
        this.id = matriculacion.getId();
        this.carrera = matriculacion.getCarrera();
        this.estudiante = matriculacion.getEstudiante();
        this.inscripcion = matriculacion.getInscripcion();
        this.graduacion = matriculacion.getGraduacion();
        this.antiguedad = matriculacion.getAntiguedad();
    }


    public MatriculaResponseDTO(CarreraResponseDTO c, EstudianteResponseDTO e, Matricula matriculacion) {
        this.carrera = c;
        this.estudiante = e;
        this.id = matriculacion.getId();
        this.inscripcion = matriculacion.getInscripcion();
        this.graduacion = matriculacion.getGraduacion();
        this.antiguedad = matriculacion.getAntiguedad();
    }
}
