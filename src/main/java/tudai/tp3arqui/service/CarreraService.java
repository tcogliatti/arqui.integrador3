package tudai.tp3arqui.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tudai.tp3arqui.dto.requests.CarreraRequestDTO;
import tudai.tp3arqui.dto.responses.*;
import tudai.tp3arqui.exceptions.NotFoundEntity;
import tudai.tp3arqui.model.Carrera;
import tudai.tp3arqui.repository.CarreraRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    public List<CarreraReporteResponseDTO> reporte() {
        // Obtener reporte de graduados
        List<CarreraReporteGraduadoResponseDTO> resultsGraduados = this.carreraRepository.reporteGraduados()
                .stream().map(item -> {
                    String nombre = (String) item[0];
                    Integer anio = ((Number) item[1]).intValue();
//                    Integer inscriptos = ((Number) item[2]).intValue();
                    Integer graduados = ((Number) item[2]).intValue();
                    CarreraReporteGraduadoResponseDTO cr = new CarreraReporteGraduadoResponseDTO(nombre, anio, graduados);
                    return cr;
                }).toList();

        // Obtener reporte de inscriptos
        List<CarreraReporteInscriptoResponseDTO> resultsInscriptos = this.carreraRepository.reporteInscriptos()
                .stream().map(item -> {
                    String nombre = (String) item[0];
                    Integer anio = ((Number) item[1]).intValue();
                    Integer inscriptos = ((Number) item[2]).intValue();
//                    Integer graduados = ((Number) item[2]).intValue();
                    CarreraReporteInscriptoResponseDTO cr = new CarreraReporteInscriptoResponseDTO(nombre, anio, inscriptos);
                    return cr;
                }).toList();

        return  combinarListas(resultsGraduados,resultsInscriptos);
    }

    private static List<CarreraReporteResponseDTO> combinarListas(
            List<CarreraReporteGraduadoResponseDTO> graduadosList,
            List<CarreraReporteInscriptoResponseDTO> inscriptosList) {

        Map<String, Map<Integer, CarreraReporteResponseDTO>> mapaCombinado = new HashMap<>();

        // Procesar lista de graduados
        for (CarreraReporteGraduadoResponseDTO graduado : graduadosList) {
            String carrera = graduado.getNombre();
            int anio = graduado.getAnio();
            mapaCombinado.computeIfAbsent(carrera, k -> new HashMap<>())
                    .put(anio, new CarreraReporteResponseDTO(carrera, anio, 0, graduado.getGraduados()));
        }

        // Procesar lista de inscriptos
        for (CarreraReporteInscriptoResponseDTO inscripto : inscriptosList) {
            String carrera = inscripto.getNombre();
            int anio = inscripto.getAnio();
            mapaCombinado.computeIfAbsent(carrera, k -> new HashMap<>())
                    .merge(anio, new CarreraReporteResponseDTO(carrera, anio, inscripto.getInscriptos(), 0),
                            (existing, additional) -> {
                                existing.setInscriptos(additional.getInscriptos());
                                return existing;
                            });
        }

        // Convertir el mapa combinado a una lista
        List<CarreraReporteResponseDTO> resultado = new ArrayList<>();
        for (Map<Integer, CarreraReporteResponseDTO> aniosMap : mapaCombinado.values()) {
            resultado.addAll(aniosMap.values());
        }

        return resultado;
    }
}
