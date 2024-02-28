package com.javabank.classes;

public class ContaPJ extends Conta {

    private int cnpj;
    public static double imposto = 0.1;

    public ContaPJ(String titular, double saldo, int cnpj, int id){
     super(titular, saldo, id);
     this.cnpj = cnpj;
    } 

    @Override
    public void transferir(double valor, Conta contaDestino){
        this.saldo = this.saldo - (valor *(1.00+imposto));
        contaDestino.saldo = contaDestino.saldo + valor;
    }
}
