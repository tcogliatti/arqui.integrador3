package tudai.tp3arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.model.Estudiante;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE LOWER(e.genero) LIKE LOWER(:genero)")
    public List<Estudiante> findByGenero(String genero);

    Estudiante findByLu(int lu);

    @Query("SELECT e FROM Estudiante e " +
            "JOIN Matricula m ON m.estudiante = e AND m.carrera = :c" +
            " WHERE LOWER(e.direccion) = LOWER(:ciudad)")
    public List<Estudiante>  findByInscripcionesAndDireccion(Carrera c, String ciudad);
}

