package tudai.tp3arqui.controller;

import tudai.tp3arqui.dto.responses.CarreraInscriptosResponseDTO;
import tudai.tp3arqui.dto.responses.CarreraResponseReporteDTO;
import tudai.tp3arqui.service.CarreraService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tudai.tp3arqui.dto.requests.CarreraRequestDTO;
import tudai.tp3arqui.dto.responses.CarreraResponseDTO;

@RestController
@RequestMapping("api/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping("")
    public List<CarreraResponseDTO> findAll(){
        return this.carreraService.findAll();
    }

    @GetMapping("/{idCarrera}")
    public CarreraResponseDTO findById(@PathVariable Long idCarrera){
        return this.carreraService.findByIdCarrera(idCarrera);
    }

    @GetMapping("/cantidadInsciptos")
    public List<CarreraInscriptosResponseDTO> getCantInscriptosPorCarrera(){
        return this.carreraService.getCantInscriptosPorCarrera();
    }
    @GetMapping("/reporte")
    public List<CarreraResponseReporteDTO> reporte(){
        return this.carreraService.reporte();
    }


    @PostMapping("")
    public ResponseEntity<CarreraResponseDTO> save(@RequestBody @Validated CarreraRequestDTO request){
        final var result = this.carreraService.save(request);
        return ResponseEntity.accepted().body(result);
    }

}
