package tudai.tp3arqui.dto.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CarreraRequestDTO {

    @NotNull(message = "Nombre de carrera es un campo obligatorio")
    @NotEmpty(message ="Nombre de carrera es un campo obligatorio")
    private Long idCarrera;
    private String nombre;
    private int duracion;

}
