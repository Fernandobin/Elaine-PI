/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bonsspassos.loja.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author FernandoBindandi
 */
public class Conexao {

    public Connection getConexao()  {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bons-passos?user=root&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
