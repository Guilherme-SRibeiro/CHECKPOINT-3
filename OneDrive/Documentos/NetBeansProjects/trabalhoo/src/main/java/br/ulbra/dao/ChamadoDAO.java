package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.util.List;

public interface ChamadoDAO {
    void salvar(Chamado c);
    List<Chamado> listar();
    void atualizar(Chamado c);
    void excluir(int id);
}