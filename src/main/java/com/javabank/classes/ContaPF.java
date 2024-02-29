package com.javabank.classes;

public class ContaPF extends Conta {

    private int cpf;
    public static double imposto = 0.05;

    public ContaPF(String titular, double saldo, int cpf, int id){
     super(titular, saldo, id);
     this.cpf = cpf;
    } 
    
    @Override
    public void transferir(double valor, Conta contaDestino){
        this.saldo = this.saldo - (valor *(1.00+imposto));
        contaDestino.saldo = contaDestino.saldo + valor;
    }
}
