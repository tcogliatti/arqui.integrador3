package tudai.tp3arqui.dto.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.model.Estudiante;

@Data
@JsonIgnoreProperties
public class MatriculaRequestDTO {

//    @NotNull(message = "Nombre estudiante es un campo obligatorio")
//    @NotEmpty(message ="Nombre estudiante es un campo obligatorio")
    private Long carrera;
    private Long estudiante;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
}
