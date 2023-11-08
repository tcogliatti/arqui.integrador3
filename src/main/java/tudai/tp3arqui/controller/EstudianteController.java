package tudai.tp3arqui.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tudai.tp3arqui.dto.requests.EstudianteRequestDTO;
import tudai.tp3arqui.dto.responses.EstudianteResponseDTO;
import tudai.tp3arqui.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("")
    public List<EstudianteResponseDTO> findAll() {
        return this.estudianteService.findAll();
    }

    @GetMapping("/{dni}")
    public EstudianteResponseDTO findByDni(@PathVariable Long dni) {
        return this.estudianteService.findByDni(dni);
    }

    @GetMapping("/findByGenero/{genero}")
    public List<EstudianteResponseDTO> findByGenero(@PathVariable String genero) {
        return this.estudianteService.findByGenero(genero);
    }

    @GetMapping("/libreta/{lu}")
    public EstudianteResponseDTO findByLu(@PathVariable int lu) {
        return this.estudianteService.findByLu(lu);
    }

    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Validated EstudianteRequestDTO request) {
        System.out.println(request);
        final var result = this.estudianteService.save(request);
        return ResponseEntity.accepted().body(result);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<EstudianteResponseDTO> update(@RequestBody @Validated EstudianteRequestDTO request) {
        System.out.println(request);
        final var result = this.estudianteService.save(request);
        return ResponseEntity.accepted().body(result);
    }

    @DeleteMapping("/{dni}")
    public void delete(@PathVariable Long dni) {
        this.estudianteService.delete(dni);
    }
}
