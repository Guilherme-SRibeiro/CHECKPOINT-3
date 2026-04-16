package br.ulbra.controller;

import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;
import java.util.List;

public class ChamadoController {

    private ChamadoService service = new ChamadoService();

    public void salvar(Chamado c) {
        service.salvar(c);
     }

    public List<Chamado> listar() {
        return service.listar();
    }

    public void atualizar(Chamado c) {
        service.atualizar(c);
    }

    public void excluir(int id) {
        service.excluir(id);
    }
 }