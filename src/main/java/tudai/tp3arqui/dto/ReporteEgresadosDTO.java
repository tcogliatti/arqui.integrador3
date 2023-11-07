package tudai.tp3arqui.dto;

public class ReporteEgresadosDTO {
    private int anio;
    private String nombre;
    private int egresados;

    public ReporteEgresadosDTO(int anio, String nombre, int egresados) {
        this.anio = anio;
        this.nombre = nombre;
        this.egresados = egresados;
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

    public int getEgresados() {
        return egresados;
    }

    public void setEgresados(int egresados) {
        this.egresados = egresados;
    }

    @Override
    public String toString() {
        return anio +
                "\t" + nombre +
                "\t" + egresados;
    }
}
