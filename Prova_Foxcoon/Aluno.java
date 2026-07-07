package com.exemplo.alunoapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REGISTRO_ALUNO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matrícula")
    private Long matricula; [cite: 5]

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Nascimento")
    private LocalDate nascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlunoMateria> materias = new ArrayList<>();
}