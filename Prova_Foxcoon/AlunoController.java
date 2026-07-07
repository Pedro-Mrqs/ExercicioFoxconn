package com.exemplo.alunoapi.controller;

import com.exemplo.alunoapi.dto.AlunoDTO;
import com.exemplo.alunoapi.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Tarefa 4: Listar todos
    @GetMapping [cite: 12]
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    // Tarefa 5: Filtrar notas > 8
    @GetMapping("/notas-altas") [cite: 13]
    public ResponseEntity<List<AlunoDTO>> listarNotasAltas() {
        return ResponseEntity.ok(alunoService.listarComNotasAltas());
    }

    // Tarefa 2: Inserir novo
    @PostMapping [cite: 10]
    public ResponseEntity<AlunoDTO> criarAluno(@RequestBody AlunoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(dto));
    }

    // Tarefa 3: Atualizar dados e matérias
    @PutMapping("/{matricula}") [cite: 11]
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long matricula, @RequestBody AlunoDTO dto) {
        return ResponseEntity.ok(alunoService.atualizar(matricula, dto));
    }
}