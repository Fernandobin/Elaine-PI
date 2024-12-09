/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bonsspassos.loja.daos;

import com.bonsspassos.loja.configDB.Conexao;
import com.bonsspassos.loja.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FernandoBindandi
 */
public class DaoCliente {

    private final Conexao conexao = new Conexao();

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome,cpf, email, telefone,estadoCivil,sexo,endereco,dataNasc,removido) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getSexo());
            preparedStatement.setString(7, cliente.getEndereco());
            preparedStatement.setDate(8, Date.valueOf(cliente.getDataNascimento()));
            preparedStatement.setBoolean(9, false);
            preparedStatement.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> buscaCliente() {
        String sql = "SELECT * FROM clientes WHERE removido=0";
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"));

                clientes.add(cliente);
            }
            con.close();
            return clientes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Cliente> buscaCliente(String nomeColuna, String valorBusca) {
        var sql = "SELECT * FROM clientes WHERE removido=0 AND " + nomeColuna + " like ?";
        List<Cliente> clientes = new ArrayList<>();
        ResultSet rs;
        try {

            valorBusca = "%%" + valorBusca + "%%";
            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, valorBusca);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"));

                clientes.add(cliente);
            }
            con.close();
            return clientes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Cliente buscaClientePorId(int idCliente) {
        var sql = "SELECT * FROM clientes WHERE removido=0 AND id= ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            ResultSet rs = preparedStatement.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEstadoCivil("estadoCivil");
                cliente.setDataNascimento(rs.getDate("dataNasc").toLocalDate());
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
            }
            con.close();
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCliente(Cliente cliente, String cpf) {
        var sql = "UPDATE clientes SET nome=?, dataNasc=?,endereco=?,estadoCivil=?,email=?, telefone=? WHERE cpf= ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setDate(2, Date.valueOf(cliente.getDataNascimento()));
            preparedStatement.setString(3, cliente.getEndereco());
            preparedStatement.setString(4, cliente.getEstadoCivil());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setString(6, cliente.getTelefone());
            preparedStatement.setString(7, cpf.replaceAll("\\D", ""));
            preparedStatement.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public boolean removeCliente(Cliente cliente) {
        var sql = "UPDATE clientes SET removido=1 WHERE id= ?";

        try {

            Connection con = conexao.getConexao();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.execute();
            con.close();
            return true;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

}
