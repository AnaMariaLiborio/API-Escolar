package com.escola_api.escola_api.model;

public class Comunicado {

    private Long id;
    private String titulo;
    private String descricao;
    private Long turmaId;

    public Comunicado() {}

    public Comunicado(Long id, String titulo, String descricao, Long turmaId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.turmaId = turmaId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
}
