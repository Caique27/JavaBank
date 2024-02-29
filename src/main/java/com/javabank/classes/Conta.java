package com.javabank.classes;

public class Conta {
   public String titular;
   protected double saldo;
   public int id;

   public Conta(String titular, double saldo, int id){
    this.titular = titular;
    this.saldo = saldo;
    this.id = id;
   }
   
   public double getSaldo(){
    return this.saldo;
   }

   public String depositar(double valor){
    this.saldo = this.saldo + valor;
    return "R$" + valor + "depositados"; 
   }

   public void sacar(double valor){
     this.saldo = this.saldo - valor;
   }

   public void transferir(double valor, Conta contaDestino){
    this.saldo = this.saldo - valor;
    contaDestino.saldo = contaDestino.saldo + valor;
    
   }
}
