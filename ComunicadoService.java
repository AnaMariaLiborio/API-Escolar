package com.escola_api.escola_api.service;

import com.escola_api.escola_api.model.Comunicado;
import com.escola_api.escola_api.repository.ComunicadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ComunicadoService {

    private final ComunicadoRepository repo;

    public ComunicadoService(ComunicadoRepository repo) {
        this.repo = repo;
    }

    public Comunicado criar(Comunicado comunicado) {

        if (comunicado.getTitulo() == null || comunicado.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }

        if (comunicado.getDescricao() == null || comunicado.getDescricao().isBlank()) {
            throw new IllegalArgumentException("A descrição é obrigatória.");
        }

        if (comunicado.getTurmaId() == null) {
            throw new IllegalArgumentException("A turma do comunicado é obrigatória.");
        }

        return repo.salvar(comunicado);
    }

    public Comunicado buscarPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Comunicado não encontrado."));
    }

    public List<Comunicado> listarTodos() {
        return repo.listarTodos();
    }

    public List<Comunicado> listarPorTurma(Long turmaId) {
        return repo.listarPorTurma(turmaId);
    }

    public void deletar(Long id) {
        if (!repo.buscarPorId(id).isPresent()) {
            throw new NoSuchElementException("Não existe comunicado com esse ID.");
        }
        repo.deletar(id);
    }
}
