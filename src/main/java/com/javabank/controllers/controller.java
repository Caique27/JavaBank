package com.javabank.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


import com.javabank.classes.Conta;
import com.javabank.classes.ContaPF;
import com.javabank.classes.ContaPJ;

@RestController
public class controller {

    public static class RequisicaoConta {
        public String titular;
        public Double saldo;
        public String tipo;
        public int cpf_cnpj;
    }
    public static class RequisicaoTransferencia {
        public int idOrigem;
        public int idDestino;
        public double valor;
    }
    public static class RequisicaoDeposito {
        public int idConta;
        public double valor;
    }   
 
    public static ArrayList<Conta> contas = new ArrayList<Conta>();
    private static int maiorIdConta = 0;    

    @RequestMapping(value = "/contas", method = RequestMethod.GET)
    public ArrayList<Conta>  getAll() {
        return contas;        
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public Conta getById(@PathVariable(value = "id") long id) {
        int numeroContas = contas.size();
        for(int index = 0 ; index < numeroContas ; index++){
            if(contas.get(index).id == id){
                return contas.get(index);
            }
        }
        return null;
    }
    
    @RequestMapping(value = "/conta", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Conta> newAccount(@RequestBody RequisicaoConta body) {
            if (body.tipo.equals("fisica")){
            ContaPF novaConta = new ContaPF(
                body.titular,
                body.saldo,
                body.cpf_cnpj,
                maiorIdConta + 1
            );
            maiorIdConta = maiorIdConta + 1;
            contas.add(novaConta); 
        }else if (body.tipo.equals("juridica")){
            ContaPJ novaConta = new ContaPJ(
                body.titular,
                body.saldo,
                body.cpf_cnpj,
                maiorIdConta + 1
            );
            maiorIdConta = maiorIdConta + 1;
            contas.add(novaConta); 

        }
        return contas;       
    }
    
    @RequestMapping(value = "/transferencia", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Conta> transfer(@RequestBody RequisicaoTransferencia body) {
        int numeroContas = contas.size();
        Conta contaOrigem = null;
        Conta contaDestino = null;

        if(body.idOrigem == body.idDestino){
            return null;
        }
        for(int index = 0 ; index < numeroContas ; index++){
            if(contas.get(index).id == body.idOrigem){
                contaOrigem = contas.get(index);
            }
            if(contas.get(index).id == body.idDestino){
                contaDestino = contas.get(index);
            }
        }
        if(contaDestino==null || contaOrigem==null){
           System.out.println("Conta não encontrada");
           return null; 
        }
        contaOrigem.transferir(body.valor, contaDestino);
        return contas;        
    }
 
    @RequestMapping(value = "/deposito", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Conta> deposit(@RequestBody RequisicaoDeposito body) {
        Conta contaDeposito = null;
        int numeroContas = contas.size();
        for(int index = 0 ; index < numeroContas ; index++){
            if(contas.get(index).id == body.idConta){
                contaDeposito = contas.get(index);
            }
        }
        if(contaDeposito == null){
            return null;
        }
        contaDeposito.depositar(body.valor);
        return contas;
    }

}

