/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bonsspassos.loja.model;

import java.math.BigDecimal;

/**
 *
 * @author FernandoBindandi
 */
public class Produto {

    private int id;
    private String nomeProduto;
    private String departamentoProd;
    private String marcaProduto;
    private String modeloProduto;
    private Integer tamanhoProduto;
    private Integer qtdProduto;
    private BigDecimal valorProduto;

    public Produto() {
    }

    public Produto(int id, String nomeProduto, String departamentoProd, String marcaProduto,String modeloProduto,int tamanhoProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.departamentoProd = departamentoProd;
        this.marcaProduto = marcaProduto;
        this.modeloProduto = modeloProduto;
        this.tamanhoProduto=tamanhoProduto;
    }

    @Override
    public String toString() {
        return  "\nProduto: "
                + nomeProduto
                + "\nDepartamento: "
                + departamentoProd
                + "\nMarca: "
                + marcaProduto
                + "\nModelo: "
                + modeloProduto
                + "\nTamanho: " 
                + tamanhoProduto 
                + "\nQuantidade: " 
                + qtdProduto 
                + "\nValor: " 
                + valorProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamentoProd() {
        return departamentoProd;
    }

    public void setDepartamentoProd(String departamentoProd) {
        this.departamentoProd = departamentoProd;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getModeloProduto() {
        return modeloProduto;
    }

    public void setModeloProduto(String modeloProduto) {
        this.modeloProduto = modeloProduto;
    }

    public int getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(int tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }
}
