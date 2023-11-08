package tudai.tp3arqui.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tudai.tp3arqui.dto.requests.CarreraRequestDTO;
import tudai.tp3arqui.dto.responses.CarreraInscriptosResponseDTO;
import tudai.tp3arqui.dto.responses.CarreraResponseDTO;
import tudai.tp3arqui.exceptions.NotFoundEntity;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.repository.CarreraRepository;

import java.util.List;

@Service("CarreraService")
@RequiredArgsConstructor
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional(readOnly = true)
    public List<CarreraResponseDTO> findAll() {
        List<CarreraResponseDTO> results = this.carreraRepository.findAll().stream().map(CarreraResponseDTO::new).toList();
        return  results;
    }

    public CarreraResponseDTO findByIdCarrera( Long idCarrera) {
        return  this.carreraRepository.findById(idCarrera)
                .map(CarreraResponseDTO::new)
                .orElseThrow( () -> new NotFoundEntity("Carrera" , idCarrera));
    }

    @Transactional
    public CarreraResponseDTO save(CarreraRequestDTO request) {
        final var carrera = new Carrera(request);
        final var result = this.carreraRepository.save(carrera);
        return new CarreraResponseDTO(result.getIdCarrera(),result.getNombre(), result.getDuracion());
    }


    public List<CarreraInscriptosResponseDTO> getCantInscriptosPorCarrera() {
        List<CarreraInscriptosResponseDTO> results = this.carreraRepository.findAllOrderDescByMatriculados().stream().map(CarreraInscriptosResponseDTO::new).toList();
        return  results;
//        List<Object[]> results = this.carreraRepository.findAllOrderDescByMatriculados();
//
//        List<CarreraInscriptosResponseDTO> dtos = results.stream()
//                .map(result -> new CarreraInscriptosResponseDTO((Long) result[0], (String) result[1], (Long) result[2]))
//                .toList();

    }
}
