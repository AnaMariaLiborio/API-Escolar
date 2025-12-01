package com.escola_api.escola_api.service;

import com.escola_api.escola_api.model.Aluno;
import com.escola_api.escola_api.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlunoService {

    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public Aluno criarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        return repo.salvar(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado"));
    }
    

    public List<Aluno> listarTodos() {
        return repo.listarTodos(); 
    }

    public List<Aluno> listarPorTurma(String turmaId) {
        return repo.listarPorTurma(turmaId);
    }


    public void deletar(Long id) {
        this.buscarPorId(id); 
        repo.deletar(id);
    }
}
