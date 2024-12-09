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
public class ItemVenda {

    private int id;
    private int idVenda;
    private int idProduto;
    private int qtdProduto;
    private BigDecimal ValorUnit;

    public ItemVenda(int idProduto, int qtdProduto, BigDecimal ValorUnit) {
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.ValorUnit = ValorUnit;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public BigDecimal getValorUnit() {
        return ValorUnit;
    }

    public void setValorUnit(BigDecimal ValorUnit) {
        this.ValorUnit = ValorUnit;
    }

}
