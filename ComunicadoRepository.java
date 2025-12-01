package com.escola_api.escola_api.repository;

import com.escola_api.escola_api.model.Comunicado;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ComunicadoRepository {

    private final Map<Long, Comunicado> banco = new HashMap<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Comunicado salvar(Comunicado comunicado) {
        if (comunicado.getId() == null) {
            comunicado.setId(contador.getAndIncrement());
        }
        banco.put(comunicado.getId(), comunicado);
        return comunicado;
    }

    public Optional<Comunicado> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public List<Comunicado> listarTodos() {
        return new ArrayList<>(banco.values());
    }

    public List<Comunicado> listarPorTurma(Long turmaId) {
        return banco.values().stream()
                .filter(c -> Objects.equals(c.getTurmaId(), turmaId))
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        banco.remove(id);
    }
}
