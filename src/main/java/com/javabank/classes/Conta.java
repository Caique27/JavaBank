package com.javabank.classes;

public class Conta {
   public String titular;
   protected double saldo;

   public Conta(String titular, double saldo){
    this.titular = titular;
    this.saldo = saldo;
   }
   
   public double getSaldo(){
    return this.saldo;
   }

   public String depositar(double valor){
    this.saldo = this.saldo + valor;
    return "R$" + valor + "depositados"; 
   }

   public void transferir(double valor, Conta contaDestino){
    this.saldo = this.saldo - valor;
    contaDestino.saldo = contaDestino.saldo + valor;
    
   }
}
