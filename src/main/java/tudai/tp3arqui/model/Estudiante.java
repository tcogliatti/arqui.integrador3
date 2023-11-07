package tudai.tp3arqui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tudai.tp3arqui.dto.requests.EstudianteRequestDTO;

import java.util.List;

@Entity
@Getter @Setter
public class Estudiante {
    @Column
    private int lu;
    @Id
    private Long dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column
    private String direccion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<Matricula> inscripciones;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Estudiante() {
    }

    public Estudiante(EstudianteRequestDTO request){
        this.lu = request.getLu();
        this.dni = request.getDni();
        this.nombre = request.getNombre();
        this.apellido = request.getApellido();
        this.edad = request.getEdad();
        this.genero = request.getGenero();
        this.direccion = request.getDireccion();
    }

    public Estudiante(int nro_libreta, Long dni, String nombre, String apellido, int nacimiento, String genero, String direccion) {
        this.lu = nro_libreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = nacimiento;
        this.genero = genero;
        this.direccion = direccion;
    }

    public Estudiante(int nro_libreta, Long dni, String nombre, String apellido, int nacimiento, String genero, String direccion, List<Matricula> inscripciones) {
        this.lu = nro_libreta;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = nacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "lu=" + lu +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", direccion='" + direccion + '\'' +
//                ", inscripciones=" + inscripciones +
                '}';
    }
}
