package br.ulbra.view;

import br.ulbra.controller.ChamadoController;
import br.ulbra.model.Chamado;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import br.ulbra.model.Usuario;
import br.ulbra.model.Equipamento;

public class ChamadoView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChamadoView.class.getName());
    
    ChamadoController controller = new ChamadoController();
    
    public ChamadoView() {
        initComponents();
        
        comboEquipamento.removeAllItems();
        comboEquipamento.addItem("PC-01");
        comboEquipamento.addItem("PC-02");

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabelaChamados.getColumnCount(); i++) {
            tabelaChamados.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
        
        tabelaChamados.setRowHeight(25);
        
        carregarTabela();
        
    
    
        tabelaChamados.getColumnModel().getColumn(0).setPreferredWidth(50);  
        tabelaChamados.getColumnModel().getColumn(1).setPreferredWidth(120); 
        tabelaChamados.getColumnModel().getColumn(2).setPreferredWidth(80); 
        tabelaChamados.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabelaChamados.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelaChamados.getColumnModel().getColumn(5).setPreferredWidth(200);
        
        tabelaChamados.setBackground(Color.WHITE);
        tabelaChamados.setForeground(Color.BLACK);
        tabelaChamados.setSelectionBackground(new Color(0, 120, 215));
        tabelaChamados.setSelectionForeground(Color.WHITE);
        
        tabelaChamados.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabelaChamados.getTableHeader().setBackground(new Color(30, 30, 30));
        tabelaChamados.getTableHeader().setForeground(Color.WHITE);
    } 
    
public void carregarTabela() {
    DefaultTableModel modelo = (DefaultTableModel) tabelaChamados.getModel();
    modelo.setRowCount(0);

    List<Chamado> lista = controller.listar();

    for (Chamado c : lista) {
        modelo.addRow(new Object[]{
            c.getId(),
            c.getUsuario().getNome(),
            c.getEquipamento().getTagPatrimonio(),
            c.getProblemaRelatado(),
            c.getPrioridade(),
            c.getDiagnosticoTecnico()
        });
    }
} 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSolicitante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTag = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProblema = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        txtPrioridade = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaChamados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        comboEquipamento = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        jLabel4.setText("Sala");

        jLabel2.setText("Tag");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Equipamento");

        jLabel3.setText("Prioridade");

        jLabel5.setText("Problema Relatado");

        jLabel6.setText("Diagnóstico Técnico");

        txtProblema.setColumns(20);
        txtProblema.setRows(5);
        jScrollPane1.setViewportView(txtProblema);

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane2.setViewportView(txtDiagnostico);

        txtPrioridade.addActionListener(this::txtPrioridadeActionPerformed);

        tabelaChamados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Solicitante", "Sala", "Problema", "Prioridade", "Diagnóstico"
            }
        ));
        tabelaChamados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaChamadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaChamados);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        comboEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEquipamento.addActionListener(this::comboEquipamentoActionPerformed);

        jButton2.setText("Salvar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditar)
                                    .addComponent(btnExcluir))))
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(btnEditar)
                        .addGap(34, 34, 34)
                        .addComponent(btnExcluir)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrioridadeActionPerformed
        
    }//GEN-LAST:event_txtPrioridadeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        System.out.println("FUNCIONOU");
        
        Chamado c = new Chamado();
        
        Usuario u = new Usuario();
        u.setIdUsuario(1);
        c.setUsuario(u);
            
        String item = comboEquipamento.getSelectedItem().toString();

        Equipamento eq = new Equipamento();

        if (item.equals("PC-01")) {
            eq.setIdEquipamento(1);
        } else if (item.equals("PC-02")) {
            eq.setIdEquipamento(2);
        }

        c.setEquipamento(eq);

        c.setProblemaRelatado(txtProblema.getText());
        c.setDiagnosticoTecnico(txtDiagnostico.getText());
        c.setPrioridade(txtPrioridade.getText());
        c.setStatus("PENDENTE");

        controller.salvar(c);
        carregarTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
     int linha = tabelaChamados.getSelectedRow();

    if (linha != -1) {
        Chamado c = new Chamado();

        c.setId((long) tabelaChamados.getValueAt(linha, 0));

        Usuario u = new Usuario();
        u.setIdUsuario(1);
        c.setUsuario(u);

        Equipamento eq = (Equipamento) comboEquipamento.getSelectedItem();
        c.setEquipamento(eq);

        c.setProblemaRelatado(txtProblema.getText());
        c.setPrioridade(txtPrioridade.getText());
        c.setDiagnosticoTecnico(txtDiagnostico.getText());

        controller.atualizar(c);

        carregarTabela();
    } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }

          }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    int linha = tabelaChamados.getSelectedRow();

    System.out.println("CLICOU EXCLUIR");
    System.out.println("Linha: " + linha);

    if (linha != -1) {
        long id = (long) tabelaChamados.getValueAt(linha, 0);

        controller.excluir((int) id);

        carregarTabela();
    } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Selecione uma linha!");
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaChamadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaChamadosMouseClicked
    int linha = tabelaChamados.getSelectedRow();

    txtProblema.setText(tabelaChamados.getValueAt(linha, 3).toString());
    txtPrioridade.setText(tabelaChamados.getValueAt(linha, 4).toString());
    txtDiagnostico.setText(tabelaChamados.getValueAt(linha, 5).toString());
    }//GEN-LAST:event_tabelaChamadosMouseClicked

    private void comboEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEquipamentoActionPerformed

    }//GEN-LAST:event_comboEquipamentoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                        
    Chamado c = new Chamado();

    Usuario u = new Usuario();
    u.setIdUsuario(1);
    c.setUsuario(u);

    String item = comboEquipamento.getSelectedItem().toString();

    Equipamento eq = new Equipamento();

    if (item.equals("PC-01")) {
        eq.setIdEquipamento(1);
    } else if (item.equals("PC-02")) {
        eq.setIdEquipamento(2);
    }

    c.setEquipamento(eq);

    c.setProblemaRelatado(txtProblema.getText());
    c.setDiagnosticoTecnico(txtDiagnostico.getText());
    c.setPrioridade(txtPrioridade.getText());
    c.setStatus("PENDENTE");

    controller.salvar(c);

    carregarTabela();

    
     txtProblema.setText("");
    txtDiagnostico.setText("");
    txtPrioridade.setText("");

    javax.swing.JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboEquipamento;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaChamados;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtPrioridade;
    private javax.swing.JTextArea txtProblema;
    private javax.swing.JTextField txtSala;
    private javax.swing.JTextField txtSolicitante;
    private javax.swing.JTextField txtTag;
    // End of variables declaration//GEN-END:variables
}
