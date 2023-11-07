package tudai.tp3arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tudai.tp3arqui.model.Matricula;

@Repository
public interface  MatriculaRepository extends JpaRepository<Matricula, Long> {

}
