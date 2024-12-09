/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bonsspassos.loja.daos;

import com.bonsspassos.loja.configDB.Conexao;
import com.bonsspassos.loja.model.RelatorioAnalitico;
import com.bonsspassos.loja.model.RelatorioSintetico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FernandoBindandi
 */
public class DaoRelatorios {

    private final Conexao conexao = new Conexao();

    public List<RelatorioSintetico> relatorioSinteticoPorPeriodo(Date inicio, Date fim) {
        String sql = "SELECT vendas.id,clientes.nome,vendas.idCliente,vendas.dataVenda, vendas.valorVenda "
                + "FROM vendas INNER JOIN clientes ON clientes.id=vendas.idCliente"
                + " WHERE dataVenda BETWEEN ? AND ?";
        ResultSet rs = null;

        List<RelatorioSintetico> listaRelatorios = new ArrayList<>();
        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, new java.sql.Date(inicio.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(fim.getTime()));
            rs = preparedStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    listaRelatorios.add(new RelatorioSintetico(rs.getInt("idCliente"), rs.getString("nome"), rs.getBigDecimal("valorVenda"), rs.getInt("id"), rs.getDate("dataVenda")));

                }
            }
            con.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaRelatorios;
    }

    public List<RelatorioSintetico> relatorioSinteticoPorFiltro(Date inicio, Date fim, String filtro, String valor) {
        String sql = "SELECT vendas.id,clientes.nome,vendas.idCliente,vendas.dataVenda, vendas.valorVenda"
                + " FROM vendas INNER JOIN clientes ON clientes.id=vendas.idCliente "
                + "WHERE dataVenda BETWEEN ? AND ? AND " + " clientes." + filtro + " LIKE ?";
        ResultSet rs = null;
        valor = "%%" + valor + "%%";
        filtro = "clientes." + filtro;
        List<RelatorioSintetico> listaRelatorios = new ArrayList<>();
        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, new java.sql.Date(inicio.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(fim.getTime()));
            preparedStatement.setString(3, valor);
            rs = preparedStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    listaRelatorios.add(new RelatorioSintetico(rs.getInt("idCliente"),
                            rs.getString("nome"),
                            rs.getBigDecimal("valorVenda"),
                            rs.getInt("id"),
                            rs.getDate("dataVenda")));

                }
            }
            con.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaRelatorios;
    }

    public List<RelatorioAnalitico> relatorioAnalitico(int idVenda) {
        String sql = "SELECT itemvenda.idProduto,produtos.nome,itemvenda.valorUnitario,itemvenda.qtdProduto"
                + " FROM itemvenda INNER JOIN produtos ON produtos.id=itemvenda.idProduto"
                + " WHERE itemvenda.idVenda = ?";
        ResultSet rs = null;

        List<RelatorioAnalitico> listaRelatorios = new ArrayList<>();
        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idVenda);

            rs = preparedStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    listaRelatorios.add(new RelatorioAnalitico(rs.getString("nome"),
                            rs.getBigDecimal("valorUnitario"),
                            rs.getInt("qtdProduto")));

                }
            }
            con.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaRelatorios;
    }

}
