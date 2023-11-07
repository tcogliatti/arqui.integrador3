package tudai.tp3arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tudai.tp3arqui.model.Estudiante;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE LOWER(e.genero) LIKE LOWER(:genero)")
    public List<Estudiante> findByGenero(String genero);

}

