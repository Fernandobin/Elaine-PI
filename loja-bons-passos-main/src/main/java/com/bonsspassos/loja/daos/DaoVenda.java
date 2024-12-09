/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bonsspassos.loja.daos;

import com.bonsspassos.loja.configDB.Conexao;
import com.bonsspassos.loja.model.ItemVenda;
import com.bonsspassos.loja.model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FernandoBindandi
 */
public class DaoVenda {

    private final Conexao conexao = new Conexao();

    public boolean cadastrarVenda(Venda venda) {
        boolean retorno = false;
        String sql = "INSERT INTO vendas(idCliente,valorVenda,dataVenda) VALUES (?,?,?)";
        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, venda.getIdComprador());
            preparedStatement.setBigDecimal(2, venda.getTotal());
            preparedStatement.setDate(3, Date.valueOf(venda.getDataVenda()));
            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    for (ItemVenda item : venda.getItensVenda()) {
                        String sql2 = "INSERT INTO itemvenda(idVenda,idProduto,valorUnitario,qtdProduto) VALUES( ?,?,?,?)";
                        PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
                        preparedStatement2.setInt(1, id);
                        preparedStatement2.setInt(2, item.getIdProduto());
                        preparedStatement2.setBigDecimal(3, item.getValorUnit());
                        preparedStatement2.setInt(4, item.getQtdProduto());

                        int linhas = preparedStatement2.executeUpdate();
                        if (linhas > 0) {
                            retorno = true;

                        } else {
                            throw new RuntimeException("Falha realizar venda");
                        }

                    }

                }
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return retorno;
    }
}
