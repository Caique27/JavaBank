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

    public static class ContaRequisicao {
        protected String titular;
        protected Double saldo;
        protected String tipo;
        protected int cpf_cnpj;
    }
   
    public static ArrayList<Conta> contas = new ArrayList<Conta>();
    private static int maiorIdConta = 0;    

    @RequestMapping(value = "/contas", method = RequestMethod.GET)
    public ArrayList<Conta>  getAll() {
        return contas;        
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable(value = "id") long id) {
        return "chamada get" + id;        
    }
    
    @RequestMapping(value = "/conta", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Conta> post(@RequestBody ContaRequisicao body) {
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
    
    @RequestMapping(value = "/conta", method = RequestMethod.PUT)
    public String put() {
        return "chamada put";        
    }
 
    @RequestMapping(value = "/conta", method = RequestMethod.DELETE)
    public String delete() {
        return "chamada delete";        
    }

}

