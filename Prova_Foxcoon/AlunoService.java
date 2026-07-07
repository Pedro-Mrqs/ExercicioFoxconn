package com.exemplo.alunoapi.service;

import com.exemplo.alunoapi.dto.AlunoDTO;
import com.exemplo.alunoapi.dto.MateriaNotaDTO;
import com.exemplo.alunoapi.exception.ResourceNotFoundException;
import com.exemplo.alunoapi.model.Aluno;
import com.exemplo.alunoapi.model.AlunoMateria;
import com.exemplo.alunoapi.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // 4- Retornar todos os alunos e matérias
    @Transactional(readOnly = true)
    public List<AlunoDTO> listarTodos() { [cite: 12]
        return alunoRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // 5- Retornar alunos com notas superiores a 8
    @Transactional(readOnly = true)
    public List<AlunoDTO> listarComNotasAltas() { [cite: 13]
        return alunoRepository.findAlunosComNotasMaioresQueOito().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // 2- Inserir novo aluno com matérias
    @Transactional
    public AlunoDTO salvar(AlunoDTO dto) { [cite: 10]
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setSexo(dto.getSexo());
        aluno.setNascimento(dto.getNascimento());

        if (dto.getMaterias() != null) {
            Aluno finalAluno = aluno;
            List<AlunoMateria> materias = dto.getMaterias().stream().map(m -> {
                AlunoMateria am = new AlunoMateria();
                am.setAluno(finalAluno);
                am.setMateria(m.getMateria());
                am.setNotaFinal(m.getNotaFinal());
                return am;
            }).collect(Collectors.toList());
            aluno.setMaterias(materias);
        }

        return converterParaDTO(alunoRepository.save(aluno));
    }

    // 3- Atualizar dados cadastrais e gerenciar matérias (substituição/atualização)
    @Transactional
    public AlunoDTO atualizar(Long matricula, AlunoDTO dto) { [cite: 11]
        Aluno aluno = alunoRepository.findById(matricula)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com a matrícula: " + matricula));

        aluno.setNome(dto.getNome());
        aluno.setSexo(dto.getSexo());
        aluno.setNascimento(dto.getNascimento());

        // Limpa as antigas e insere a nova lista (Atendendo a "inserir ou excluir")
        aluno.getMaterias().clear();
        if (dto.getMaterias() != null) {
            Aluno finalAluno = aluno;
            List<AlunoMateria> novasMaterias = dto.getMaterias().stream().map(m -> {
                AlunoMateria am = new AlunoMateria();
                am.setAluno(finalAluno);
                am.setMateria(m.getMateria());
                am.setNotaFinal(m.getNotaFinal());
                return am;
            }).collect(Collectors.toList());
            aluno.getMaterias().addAll(novasMaterias);
        }

        return converterParaDTO(alunoRepository.save(aluno));
    }

    private AlunoDTO converterParaDTO(Aluno aluno) {
        List<MateriaNotaDTO> materiasDTO = aluno.getMaterias().stream()
                .map(m -> new MateriaNotaDTO(m.getMateria(), m.getNotaFinal()))
                .collect(Collectors.toList());

        return new AlunoDTO(
                aluno.getMatricula(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getNascimento(),
                materiasDTO
        );
    }
}