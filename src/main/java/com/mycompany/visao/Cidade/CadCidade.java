/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Cidade;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEstado;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCidade;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author stefa
 */
public class CadCidade extends javax.swing.JFrame {

    /**
     * Creates new form CadCidade
     */
    public CadCidade() {
        initComponents();
    carregarEstados();
        
        if(!existeDadosTemporarios()){
            DaoCidade daoCidade = new DaoCidade();

            int id = daoCidade.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdEstado();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfIdEstado.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModCidade){
            int id = ((ModCidade) DadosTemporarios.tempObject).getId();
            int idEstado = ((ModCidade) DadosTemporarios.tempObject).getIdEstado();
            String nome = ((ModCidade) DadosTemporarios.tempObject).getNome();
            
            tfId.setText(String.valueOf(id));
            tfIdEstado.setText(String.valueOf(idEstado));
            tfNome.setText(nome);
            
            //jcbEstado.setSelectedIndex(idEstado - 1);
            //
            try{
                DaoEstado daoEstado = new DaoEstado();
                ResultSet resultSet = daoEstado.listarPorId(idEstado);
                resultSet.next();
                String pais = resultSet.getString("ESTADO");
                int index = 0;
                for(int i = 0; i < jcbEstado.getItemCount(); i++){
                    if(jcbEstado.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                jcbEstado.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEstado.getText()), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Cidade salva com sucesso!");
            
            tfId.setText(String.valueOf(daoCidade.buscarProximoId()));
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a cidade!");
        }
    }
    
    private void alterar(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.alterar(Integer.parseInt(tfId.getText()), tfIdEstado.getText(), tfNome.getText())){
            JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso!");
            
            tfId.setText("");
            tfIdEstado.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a cidade!");
        }
        
        ((ListCidade) Formularios.listCidade).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoCidade daoCidade = new DaoCidade();
        
        if (daoCidade.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Cidade " + tfNome.getText() + " excluída com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a cidade!");
        }
        
        ((ListCidade) Formularios.listCidade).listarTodos();
        
        dispose();
    }
    
    public void carregarEstados(){
        try{
            DaoEstado daoEstado = new DaoEstado();

            ResultSet resultSet = daoEstado.listarTodos();

            while(resultSet.next()){
                jcbEstado.addItem(resultSet.getString("ESTADO"));
            }
        }catch(Exception e){
            
        }
    }
    
    private void recuperaIdEstado(){
        try{
            DaoEstado daoEstado = new DaoEstado();
            ResultSet resultSet = daoEstado.listarPorNome(jcbEstado.getSelectedItem().toString(), false);
            
            resultSet.next();
            tfIdEstado.setText(resultSet.getString("ID"));
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }
    }
    
    private void recuperaUfEstado(){
        try{
            DaoEstado daoEstado = new DaoEstado();
            ResultSet resultSet = daoEstado.listarPorNome(jcbEstado.getSelectedItem().toString(), false);
            resultSet.next();
            tfUf.setText(resultSet.getString("UF"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfIdEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        tfUf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Estado");

        jLabel3.setText("Nome");

        btnAcao.setText("Salvar");

        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAcao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir))
                        .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdEstado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfUf;
    // End of variables declaration//GEN-END:variables
}
