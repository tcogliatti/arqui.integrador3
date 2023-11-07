package tudai.tp3arqui.dto;

import java.io.Serializable;

public class ReporteCarreraDTO implements Serializable {
    private int anio;
    private String nombre;
    private int inscriptos;
    private int graduados;

    public ReporteCarreraDTO(int anio, String nombre, int inscriptos, int graduados) {
        this.anio = anio;
        this.nombre = nombre;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }

    public int getGraduados() {
        return graduados;
    }

    public void setGraduados(int graduados) {
        this.graduados = graduados;
    }

    @Override
    public String toString() {
        return anio + "\t" +
                nombre + "\t" +
                inscriptos + "\t\t" +
                graduados;
    }
}
