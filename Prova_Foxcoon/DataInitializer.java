package com.exemplo.alunoapi.config;

import com.exemplo.alunoapi.model.Aluno;
import com.exemplo.alunoapi.model.AlunoMateria;
import com.exemplo.alunoapi.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    public DataInitializer(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Criando Alunos do PDF [cite: 2]
        Aluno erik = new Aluno(null, "Erik Oliver", "M", LocalDate.parse("10/10/1987", formatter), null);
        Aluno rafael = new Aluno(null, "Rafael Dinarzio", "M", LocalDate.parse("27/09/1984", formatter), null);
        Aluno daniel = new Aluno(null, "Daniel Limis", "M", LocalDate.parse("28/11/1982", formatter), null);
        Aluno gustavo = new Aluno(null, "Gustavo Zangotto", "M", LocalDate.parse("18/07/1983", formatter), null);
        Aluno gabriel = new Aluno(null, "Gabriel Milhote", "M", LocalDate.parse("05/09/1995", formatter), null);
        Aluno bia = new Aluno(null, "Bia Santos", "F", LocalDate.parse("08/07/1998", formatter), null);

        alunoRepository.saveAll(Arrays.asList(erik, rafael, daniel, gustavo, gabriel, bia));

        // Vinculando Matérias do PDF [cite: 3]
        erik.setMaterias(Arrays.asList(
                new AlunoMateria(null, erik, "Matemática", 10.0),
                new AlunoMateria(null, erik, "Fisica", 9.0)
        ));

        rafael.setMaterias(Arrays.asList(
                new AlunoMateria(null, rafael, "Geografia", 8.0),
                new AlunoMateria(null, rafael, "Ingles", 10.0)
        ));

        daniel.setMaterias(Arrays.asList(
                new AlunoMateria(null, daniel, "Matemática", 5.0),
                new AlunoMateria(null, daniel, "Geografia", 6.0),
                new AlunoMateria(null, daniel, "Inglês", 7.0)
        ));

        bia.setMaterias(Arrays.asList(
                new AlunoMateria(null, bia, "Matemática", 10.0)
        ));

        alunoRepository.saveAll(Arrays.asList(erik, rafael, daniel, bia));
    }
}