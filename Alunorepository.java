package com.escola_api.escola_api.repository;

import com.escola_api.escola_api.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AlunoRepository {

    private final Map<Long, Aluno> db = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Aluno salvar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(seq.getAndIncrement());
        }
        db.put(aluno.getId(), aluno);
        return aluno;
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(db.values());
    }

    public List<Aluno> listarPorTurma(String turmaId) {
        return db.values().stream()
            .filter(a -> Objects.equals(a.getTurmaId(), turmaId))
            .collect(Collectors.toList());
    }


    public void deletar(Long id) {
        db.remove(id);
    }
}
