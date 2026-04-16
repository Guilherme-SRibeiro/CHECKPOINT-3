package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao = new ChamadoDAOImpl();

    public void salvar(Chamado c) {

        if (c.getUsuario() == null) {
            throw new RuntimeException("Usuário obrigatório");
        }

        if (c.getProblemaRelatado() == null || c.getProblemaRelatado().isEmpty()) {
            throw new RuntimeException("Problema obrigatório");
        }

        dao.salvar(c);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado c) {
        dao.atualizar(c);
    }

    public void excluir(int id) {
        dao.excluir(id);
    }
 }