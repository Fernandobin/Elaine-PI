package com.bonsspassos.loja.cadastro;

import com.bonsspassos.loja.daos.DaoProduto;
import com.bonsspassos.loja.model.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * @author FernandoBindandi
 */
public class CadastroProduto extends javax.swing.JFrame {

    DaoProduto cadastroProduto = new DaoProduto();

    public CadastroProduto() {

        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        departamentoProd = new javax.swing.JComboBox<>();
        qtdProduto = new javax.swing.JSpinner();
        btnCadastroProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tamanhoProduto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        modeloProduto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        marcaProduto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        valorProduto = new javax.swing.JTextField();

        setTitle("LOJA BONS PASSOS - CADASTRO DE PRODUTOS");
        setResizable(false);

        jLabel1.setText("Produto:");

        nomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade:");

        jLabel3.setText("Departamento:");

        departamentoProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Streetwear", "Corrida", "Academia e Treino", "Chuteiras", "Basquete", "Sandalias e Chinelos" }));
        departamentoProd.setToolTipText("");
        departamentoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departamentoProdActionPerformed(evt);
            }
        });

        qtdProduto.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        btnCadastroProduto.setText("Cadastrar");
        btnCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tamanho:");

        tamanhoProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "34", "36", "38", "40", "41", "42", "43", "44", "45", "46", "47", "48" }));
        tamanhoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanhoProdutoActionPerformed(evt);
            }
        });

        jLabel5.setText("Modelo:");

        modeloProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Unissex" }));
        modeloProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloProdutoActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca:");

        marcaProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nike", "Tesla", "Adidas", "Mizuno", "DC Shoes", "QIX", "Puma", "Vans", "New Balance", "Hocks" }));
        marcaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaProdutoActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor:");

        jLabel8.setText("CADASTRO DE PRODUTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marcaProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeProduto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departamentoProd, 0, 220, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tamanhoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(valorProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(qtdProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(modeloProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(marcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(departamentoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(modeloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tamanhoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(qtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeProdutoActionPerformed

    }//GEN-LAST:event_nomeProdutoActionPerformed

    private void btnCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutoActionPerformed
        Produto produto = new Produto();
        List<String> result = validaCamposProduto(nomeProduto, valorProduto);
        if (result.size() == 0) {
            produto.setNomeProduto(nomeProduto.getText());
            produto.setMarcaProduto(marcaProduto.getSelectedItem().toString());
            produto.setDepartamentoProd(departamentoProd.getSelectedItem().toString());
            produto.setModeloProduto(modeloProduto.getSelectedItem().toString());
            produto.setTamanhoProduto(Integer.parseInt(tamanhoProduto.getSelectedItem().toString()));
            produto.setQtdProduto(Integer.parseInt(qtdProduto.getValue().toString()));
            produto.setValorProduto(new BigDecimal(valorProduto.getText().replace(",", ".")));
            int op = JOptionPane.showConfirmDialog(rootPane, "Confirmar cadastro?\n\n" + produto + "\n\n", "CONFIRME OS DADOS DE CADASTRO", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (op) {
                case JOptionPane.YES_OPTION:
                    try {

                        cadastroProduto.cadastrarProduto(produto);
                        JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso!", "Cadastro concluido", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao realizar Cadastro", "Erro ao cadastrar", ERROR_MESSAGE);
                        System.out.println(e.getMessage());
                    }
                    break;
                case JOptionPane.NO_OPTION:
                case JOptionPane.CANCEL_OPTION:
                    break;

            }
        } else {
            StringBuilder erros = new StringBuilder();
            for (String erro : result) {
                erros.append(erro).append("\n");
            }
            JOptionPane.showMessageDialog(rootPane, erros.toString(), "Erro ao realizar cadastro", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnCadastroProdutoActionPerformed

    public static List<String> validaCamposProduto(
            JTextField nomeProduto,
            JTextField valorProduto
    ) {
        List<String> camposNulos = new ArrayList<String>();

        if (nomeProduto.getText().isBlank()) {
            camposNulos.add("O campo produto deve ser preenchido!");
        }
        if (valorProduto.getText().isBlank()) {
            camposNulos.add("O campo valor deve ser preenchido!");
        }
        return camposNulos;
    }

    private void marcaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaProdutoActionPerformed

    }//GEN-LAST:event_marcaProdutoActionPerformed

    private void departamentoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departamentoProdActionPerformed

    }//GEN-LAST:event_departamentoProdActionPerformed

    private void modeloProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloProdutoActionPerformed

    }//GEN-LAST:event_modeloProdutoActionPerformed

    private void tamanhoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanhoProdutoActionPerformed

    }//GEN-LAST:event_tamanhoProdutoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroProduto;
    private javax.swing.JComboBox<String> departamentoProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> marcaProduto;
    private javax.swing.JComboBox<String> modeloProduto;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JSpinner qtdProduto;
    private javax.swing.JComboBox<String> tamanhoProduto;
    private javax.swing.JTextField valorProduto;
    // End of variables declaration//GEN-END:variables
}
