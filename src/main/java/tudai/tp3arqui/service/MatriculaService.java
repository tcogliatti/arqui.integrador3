package tudai.tp3arqui.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tudai.tp3arqui.dto.requests.MatriculaRequestDTO;
import tudai.tp3arqui.dto.responses.MatriculaResponseDTO;
import tudai.tp3arqui.exceptions.NotFoundEntity;
import tudai.tp3arqui.model.Matricula;
import tudai.tp3arqui.repository.MatriculaRepository;

import java.util.List;

@Service("MatriculaService")
@RequiredArgsConstructor
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;


    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> findAll() {
        List<MatriculaResponseDTO> results = this.matriculaRepository.findAll().stream().map(MatriculaResponseDTO::new).toList();
        return results;
    }

    public MatriculaResponseDTO findById(Long id) {
        return this.matriculaRepository.findById(id)
                .map(MatriculaResponseDTO::new)
                .orElseThrow( () -> new NotFoundEntity( "Matricula" , id));
    }

    @Transactional
    public MatriculaResponseDTO save(MatriculaRequestDTO request) {
        final var matriculacion = new Matricula(request);
        final var result = this.matriculaRepository.save(matriculacion);
        return new MatriculaResponseDTO(result.getId(), result.getCarrera(), result.getInscripcion(),result.getGraduacion(), result.getAntiguedad());
    }


}
