package com.exemplo.alunoapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ALUNO_MATERIA")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Matricula", nullable = false) [cite: 6, 7]
    private Aluno aluno;

    @Column(name = "Matéria", nullable = false)
    private String materia;

    @Column(name = "Nota_Final")
    private Double notaFinal;
}