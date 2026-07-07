package com.exemplo.alunoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private Long matricula;
    private String nome;
    private String sexo;
    private LocalDate nascimento;
    private List<MateriaNotaDTO> materias;
}