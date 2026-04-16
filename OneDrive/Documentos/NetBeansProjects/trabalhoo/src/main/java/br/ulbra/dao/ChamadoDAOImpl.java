package br.ulbra.dao;

import br.ulbra.model.Chamado;
import br.ulbra.model.Usuario;
import br.ulbra.model.Equipamento;

import java.sql.*;
import java.util.*;

public class ChamadoDAOImpl implements ChamadoDAO {

    private Connection conn = ConnectionFactory.getConnection();

@Override
public void salvar(Chamado chamado) {
    String sql = "INSERT INTO chamado_tecnico "
            + "(id_usuario, id_equipamento, problema_relatado, diagnostico_tecnico, prioridade, status) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, chamado.getUsuario().getIdUsuario());
        stmt.setInt(2, chamado.getEquipamento().getIdEquipamento());
        stmt.setString(3, chamado.getProblemaRelatado());
        stmt.setString(4, chamado.getDiagnosticoTecnico());
        stmt.setString(5, chamado.getPrioridade());
        stmt.setString(6, chamado.getStatus());

        stmt.executeUpdate();

        System.out.println("SALVOU NO BANCO");

    } catch (Exception e) {
        e.printStackTrace();
     }
}

@Override
public List<Chamado> listar() {
    List<Chamado> lista = new ArrayList<>();

    String sql = "SELECT c.id, u.nome, e.tag_patrimonio, c.problema_relatado, c.prioridade, c.diagnostico_tecnico " +
                 "FROM chamado_tecnico c " +
                 "JOIN usuarios u ON c.id_usuario = u.id_usuario " +
                 "JOIN equipamentos e ON c.id_equipamento = e.id_equipamento";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

while (rs.next()) {
    Chamado c = new Chamado();
    c.setId(rs.getLong("id"));

    Usuario u = new Usuario();
    u.setNome(rs.getString("nome"));

    Equipamento e = new Equipamento();
    e.setTagPatrimonio(rs.getString("tag_patrimonio"));

    c.setUsuario(u);
    c.setEquipamento(e);

    c.setProblemaRelatado(rs.getString("problema_relatado"));
    c.setPrioridade(rs.getString("prioridade"));
    c.setDiagnosticoTecnico(rs.getString("diagnostico_tecnico"));

    lista.add(c);
}

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

    @Override
    public void atualizar(Chamado c) {
        String sql = "UPDATE chamado_tecnico SET "
                + "id_usuario=?, id_equipamento=?, problema_relatado=?, diagnostico_tecnico=?, prioridade=?, status=? "
                + "WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getUsuario().getIdUsuario());
            stmt.setInt(2, c.getEquipamento().getIdEquipamento());
            stmt.setString(3, c.getProblemaRelatado());
            stmt.setString(4, c.getDiagnosticoTecnico());
            stmt.setString(5, c.getPrioridade());
            stmt.setString(6, c.getStatus());
            stmt.setLong(7, c.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM chamado_tecnico WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}