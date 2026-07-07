package com.exemplo.alunoapi.repository;

import com.exemplo.alunoapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Query customizada para trazer apenas alunos e matérias com nota > 8
    @Query("SELECT DISTINCT a FROM Aluno a JOIN FETCH a.materias m WHERE m.notaFinal > 8") [cite: 13]
    List<Aluno> findAlunosComNotasMaioresQueOito();
}