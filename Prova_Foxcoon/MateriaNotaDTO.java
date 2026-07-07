package com.exemplo.alunoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaNotaDTO {
    private String materia;
    private Double notaFinal;
}