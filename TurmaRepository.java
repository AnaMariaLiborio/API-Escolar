package com.escola_api.escola_api.repository;

import com.escola_api.escola_api.model.Turma;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TurmaRepository {

    private final Map<Long, Turma> db = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Turma salvar(Turma turma) {
        if (turma.getId() == null) {
            turma.setId(seq.getAndIncrement());
        }
        db.put(turma.getId(), turma);
        return turma;
    }

    public Optional<Turma> buscarPorId(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<Turma> listarTodos() {
        return new ArrayList<>(db.values());
    }

    public void deletar(Long id) {
        db.remove(id);
    }
}
