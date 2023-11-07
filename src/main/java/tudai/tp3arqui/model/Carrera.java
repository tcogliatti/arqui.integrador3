package tudai.tp3arqui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tudai.tp3arqui.dto.requests.CarreraRequestDTO;

import java.util.List;

@Entity
@Getter @Setter
public class Carrera {
    @Id
    private Long idCarrera;
    @Column
    private String nombre;
    @Column
    private int duracion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
    private List<Matricula> matriculados;

    public Carrera() {}

    public Carrera (CarreraRequestDTO request){
        this.idCarrera = request.getIdCarrera();
        this.nombre = request.getNombre();
        this.duracion = request.getDuracion();
    }

    public Carrera(Long idCarrera, String nombre, int duracion) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    public Carrera(Long idCarrera, String nombre, int duracion, List<Matricula> matriculados) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.matriculados = matriculados;
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
//                ", matriculados=" + matriculados +
                '}';
    }
}

