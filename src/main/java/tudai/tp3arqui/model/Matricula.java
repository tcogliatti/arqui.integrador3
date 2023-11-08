package tudai.tp3arqui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tudai.tp3arqui.dto.requests.MatriculaRequestDTO;

@Entity
@Getter @Setter
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Carrera carrera;
    @ManyToOne
    private Estudiante estudiante;
    @Column
    private int inscripcion;
    @Column
    private int graduacion;
    @Column
    private int antiguedad;

    public Matricula() {
    }

    public Matricula(Long id, Carrera carrera, Estudiante estudiante, int inscripcion, int graduado, int antiguedad) {
        this.id = id;
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduacion = graduado;
        this.antiguedad = antiguedad;
    }
    public Matricula(Carrera carrera, Estudiante estudiante, int inscripcion, int graduado, int antiguedad) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduacion = graduado;
        this.antiguedad = antiguedad;
    }

//    public Matricula(MatriculaRequestDTO request) {
//        this.carrera = request.getCarrera();
//        this.estudiante = request.getEstudiante();
//        this.inscripcion = request.getInscripcion();
//        this.graduacion = request.getGraduacion();
//        this.antiguedad = request.getAntiguedad();
//    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", carrera=" + carrera +
                ", estudiante=" + estudiante +
                ", inscripcion=" + inscripcion +
                ", graduado=" + graduacion +
                '}';
    }

}