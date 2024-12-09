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
public class RelatorioAnalitico {

    private String nomeProduto;
    private BigDecimal valorUnit;
    private int qtdProduto;

    public RelatorioAnalitico(String nomeProduto, BigDecimal valorUnit, int qtdProduto) {
        this.nomeProduto = nomeProduto;
        this.valorUnit = valorUnit;
        this.qtdProduto = qtdProduto;
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

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

}
