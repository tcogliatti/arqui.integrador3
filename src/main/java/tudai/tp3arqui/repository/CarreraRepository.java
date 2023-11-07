package tudai.tp3arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tudai.tp3arqui.model.Carrera;

import java.util.List;

public interface  CarreraRepository extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c WHERE c.nombre = :nombre ")
    public List<Carrera> findAllByNombre(String nombre);
}
