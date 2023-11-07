package tudai.tp3arqui.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tudai.tp3arqui.dto.requests.EstudianteRequestDTO;
import tudai.tp3arqui.dto.responses.EstudianteResponseDTO;
import tudai.tp3arqui.exceptions.NotFoundEntity;
import tudai.tp3arqui.model.Estudiante;
import tudai.tp3arqui.repository.EstudianteRepository;

import java.util.List;


@Service("EstudianteService")
@RequiredArgsConstructor
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> findAll() {
        List<EstudianteResponseDTO> results = this.estudianteRepository.findAll().stream().map(EstudianteResponseDTO::new).toList();
        return results;
    }

    public EstudianteResponseDTO findByDni(Long dni) {
        return this.estudianteRepository.findById(dni)
                .map(EstudianteResponseDTO::new)
                .orElseThrow(() -> new NotFoundEntity("Estudiante", dni));
    }
    public List<EstudianteResponseDTO> findByGenero(String genero) {
        return this.estudianteRepository.findByGenero(genero).stream().map(EstudianteResponseDTO::new).toList();
    }

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request) {
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(
                result.getLu(),
                result.getDni(),
                result.getNombre(),
                result.getApellido(),
                result.getEdad(),
                result.getGenero(),
                result.getDireccion()
        );
    }
    @Transactional
    public void delete(Long dni){
        this.estudianteRepository.deleteById(dni);
    }
}