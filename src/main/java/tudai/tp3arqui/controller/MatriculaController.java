package tudai.tp3arqui.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tudai.tp3arqui.dto.requests.MatriculaRequestDTO;
import tudai.tp3arqui.dto.responses.MatriculaResponseDTO;
import tudai.tp3arqui.service.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("")
    public List<MatriculaResponseDTO> findAll(){
        return this.matriculaService.findAll();
    }

    @GetMapping("/{id}")
    public MatriculaResponseDTO findById(@PathVariable Long id){
        return  this.matriculaService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<MatriculaResponseDTO> save(@RequestBody @Validated MatriculaRequestDTO request){
        final var result = this.matriculaService.save(request);
        return ResponseEntity.accepted().body(result);
    }
}
