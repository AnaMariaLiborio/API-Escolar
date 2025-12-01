package com.escola_api.escola_api.service;

import com.escola_api.escola_api.model.Turma;
import com.escola_api.escola_api.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TurmaService {

    private final TurmaRepository repo;

    public TurmaService(TurmaRepository repo) {
        this.repo = repo;
    }

    public Turma criar(Turma turma) {
        if (turma.getNome() == null || turma.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        return repo.salvar(turma);
    }

    public Turma buscarPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Turma não encontrada"));
    }

    public List<Turma> listarTodos() {
        return repo.listarTodos();
    }

    public void deletar(Long id) {
        repo.deletar(id);
    }
}
