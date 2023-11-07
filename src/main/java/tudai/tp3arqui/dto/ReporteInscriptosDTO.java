package tudai.tp3arqui.dto;

import java.io.Serializable;

public class ReporteInscriptosDTO implements Serializable {
    private Integer anio;
    private String nombre;
    private Integer inscriptos;

    public ReporteInscriptosDTO(Integer anio, String nombre, Integer inscriptos) {
        this.anio = anio;
        this.nombre = nombre;
        this.inscriptos = inscriptos;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  Integer getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos( Integer inscriptos) {
        this.inscriptos = inscriptos;
    }

    @Override
    public String toString() {
        return anio +
                "\t" + nombre +
                "\t" + inscriptos;
    }
}
