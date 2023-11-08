package tudai.tp3arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tudai.tp3arqui.dto.responses.CarreraResponseReporteDTO;
import tudai.tp3arqui.model.Carrera;

import java.util.Arrays;
import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c WHERE c.nombre = :nombre ")
    public List<Carrera> findAllByNombre(String nombre);

   @Query("SELECT c FROM Carrera c ORDER BY SIZE(c.matriculados) DESC")
    public List<Carrera> findAllOrderDescByMatriculados();

   @Query( "SELECT c.nombre, m.inscripcion AS anio, COUNT(m.inscripcion) AS inscriptos FROM Carrera c " +
           "JOIN Matricula m ON m.carrera.idCarrera = c.idCarrera " +
           "GROUP BY c.nombre, m.inscripcion " +
           "ORDER BY c.nombre " +
           "UNION " +
           "SELECT c.nombre, m.graduacion AS anio, COUNT(m.graduacion) AS graduados FROM Carrera c " +
           "JOIN Matricula m ON m.carrera.idCarrera = c.idCarrera " +
           "GROUP BY c.nombre, m.graduacion " +
           "ORDER BY c.nombre ")
    public List<Object[]> reporte();
}
