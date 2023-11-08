package tudai.tp3arqui.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tudai.tp3arqui.dto.requests.MatriculaRequestDTO;
import tudai.tp3arqui.dto.responses.CarreraResponseDTO;
import tudai.tp3arqui.dto.responses.EstudianteResponseDTO;
import tudai.tp3arqui.dto.responses.MatriculaResponseDTO;
import tudai.tp3arqui.exceptions.NotFoundEntity;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.model.Estudiante;
import tudai.tp3arqui.model.Matricula;
import tudai.tp3arqui.repository.CarreraRepository;
import tudai.tp3arqui.repository.EstudianteRepository;
import tudai.tp3arqui.repository.MatriculaRepository;

import java.util.List;

@Service("MatriculaService")
@RequiredArgsConstructor
public class MatriculaService {

    @Autowired
    private final MatriculaRepository matriculaRepository;

    @Autowired
    private final CarreraRepository cr;

    @Autowired
    private final EstudianteRepository er;

    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> findAll() {
        List<MatriculaResponseDTO> results = this.matriculaRepository.findAll().
                stream().map(mat -> {
                    MatriculaResponseDTO resp = new MatriculaResponseDTO(
                        new CarreraResponseDTO(mat.getCarrera()),
                        new EstudianteResponseDTO(mat.getEstudiante()),
                        mat
                    );
                    return resp;
                }).toList();
        return results;
    }

    public MatriculaResponseDTO findById(Long id) {
        return this.matriculaRepository.findById(id)
                .map(mat -> {
                    MatriculaResponseDTO resp = new MatriculaResponseDTO(
                            new CarreraResponseDTO(mat.getCarrera()),
                            new EstudianteResponseDTO(mat.getEstudiante()),
                            mat
                    );
                    return resp;
                }).orElseThrow( () -> new NotFoundEntity( "Matricula" , id));
    }

    @Transactional
    public MatriculaResponseDTO save(MatriculaRequestDTO request) {
        Carrera c = this.cr.findById(request.getCarrera()).orElseThrow( () -> new NotFoundEntity( "Carrera" , request.getCarrera()));
        Estudiante e = this.er.findById(request.getEstudiante()).orElseThrow( () -> new NotFoundEntity("Estudiante", request.getEstudiante()));
        final var matriculacion = new Matricula(
                c,
                e,
                request.getInscripcion(),
                request.getGraduacion(),
                request.getAntiguedad()
        );
        final var result = this.matriculaRepository.save(matriculacion);
        return new MatriculaResponseDTO(
                new CarreraResponseDTO(c),
                new EstudianteResponseDTO(e),
                matriculacion
        );
    }


}
