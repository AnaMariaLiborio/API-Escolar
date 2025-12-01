package com.escola_api.escola_api.model;

import java.time.LocalDate;
import java.util.List;

public class Aluno {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String turmaId; 
    private List<String> responsaveisIds; 

    public Aluno() {}

    public Aluno(Long id, String nome, LocalDate dataNascimento, String turmaId, List<String> responsaveisIds) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.turmaId = turmaId;
        this.responsaveisIds = responsaveisIds;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getTurmaId() { return turmaId; }
    public void setTurmaId(String turmaId) { this.turmaId = turmaId; }

    public List<String> getResponsaveisIds() { return responsaveisIds; }
    public void setResponsaveisIds(List<String> responsaveisIds) { this.responsaveisIds = responsaveisIds; }
}
