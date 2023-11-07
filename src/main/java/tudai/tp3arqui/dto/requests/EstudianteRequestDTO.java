package tudai.tp3arqui.dto.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstudianteRequestDTO {

//    @NotNull(message = "Nombre es un campo obligatorio") // aplica a Integer pero no a int ya que no puede ser null
//    @NotEmpty(message = "Nombre es un campo obligatorio") // aplica a String
    private int lu;
    private Long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String direccion;
}
