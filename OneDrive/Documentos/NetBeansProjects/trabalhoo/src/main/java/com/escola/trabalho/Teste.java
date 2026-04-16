package com.escola.trabalho;

import br.ulbra.controller.ChamadoController;
import br.ulbra.model.Chamado;
import br.ulbra.model.Usuario;
import br.ulbra.model.Equipamento;

public class Teste {
    public static void main(String[] args) {

        ChamadoController controller = new ChamadoController();

        Chamado c = new Chamado();

        // usuario
        Usuario u = new Usuario();
        u.setIdUsuario(1);

        // equipamento
        Equipamento eq = new Equipamento();
        eq.setIdEquipamento(1);

        c.setUsuario(u);
        c.setEquipamento(eq);

        c.setProblemaRelatado("Computador nao liga");
        c.setDiagnosticoTecnico("Fonte queimada");
        c.setPrioridade("ALTA");
        c.setStatus("PENDENTE");

        controller.salvar(c);

        System.out.println("Salvou!");

        for (Chamado ch : controller.listar()) {
            System.out.println(
                ch.getId() + " - " +
                ch.getProblemaRelatado() + " - " +
                ch.getPrioridade()
            );
        }
    }
}