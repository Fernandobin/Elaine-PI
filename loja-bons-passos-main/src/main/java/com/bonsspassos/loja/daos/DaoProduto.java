package com.bonsspassos.loja.daos;

import com.bonsspassos.loja.configDB.Conexao;
import com.bonsspassos.loja.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FernandoBindandi
 */
public class DaoProduto {

    private final Conexao conexao = new Conexao();

    public void cadastrarProduto(Produto produto) {

        String sql = "INSERT INTO produtos(nome, marca, departamento, modelo, tamanho, quantidade, valor, removido) VALUES (?,?,?,?,?,?,?,?)";

        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setString(2, produto.getMarcaProduto());
            preparedStatement.setString(3, produto.getDepartamentoProd());
            preparedStatement.setString(4, produto.getModeloProduto());
            preparedStatement.setInt(5, produto.getTamanhoProduto());
            preparedStatement.setInt(6, produto.getQtdProduto());
            preparedStatement.setString(7, String.valueOf(produto.getValorProduto()));
            preparedStatement.setBoolean(8, false);
            preparedStatement.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Produto> buscaProduto() {
        String sql = "SELECT * FROM produtos WHERE removido = 0";
        List<Produto> produtos = new ArrayList<>();
        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("departamento"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("tamanho"));

                produtos.add(produto);
            }
            con.close();
            return produtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> buscaProduto(String nomeColuna, String valorBusca) {
        String sql = "SELECT * FROM produtos WHERE removido=0 AND " + nomeColuna + " like ?";
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs;
        try {

            valorBusca = "%%" + valorBusca + "%%";
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, valorBusca);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("departamento"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("tamanho"));
                produtos.add(produto);
            }
            con.close();
            return produtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Produto buscaProdutoPorId(int idProduto) {
        var sql = "SELECT * FROM produtos WHERE removido = 0 and id = ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idProduto);
            ResultSet rs = preparedStatement.executeQuery();
            Produto produto = new Produto();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNomeProduto(rs.getString("nome"));
                produto.setMarcaProduto(rs.getString("marca"));
                produto.setDepartamentoProd(rs.getString("departamento"));
                produto.setModeloProduto(rs.getString("modelo"));
                produto.setTamanhoProduto(rs.getInt("tamanho"));
                produto.setQtdProduto(rs.getInt("quantidade"));
                produto.setValorProduto(rs.getBigDecimal("valor"));
            }
            con.close();
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateProduto(Produto produto, int id) {
        var sql = "UPDATE produtos SET nome = ?, marca = ?, departamento = ?, modelo = ?, tamanho = ?, quantidade = ?, valor = ? WHERE id= ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setString(2, produto.getMarcaProduto());
            preparedStatement.setString(3, produto.getDepartamentoProd());
            preparedStatement.setString(4, produto.getModeloProduto());
            preparedStatement.setInt(5, produto.getTamanhoProduto());
            preparedStatement.setInt(6, produto.getQtdProduto());
            preparedStatement.setBigDecimal(7, produto.getValorProduto());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public boolean removeProduto(Produto produto) {
        var sql = "UPDATE produtos SET removido = 1 WHERE id = ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.execute();
            con.close();
            return true;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
