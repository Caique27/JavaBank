package com.javabank.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabank.classes.Conta;
import com.javabank.classes.ContaPF;
import com.javabank.classes.ContaPJ;

@RestController
public class controller {
   

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public String getAll() {
        return "chamada get";        
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable(value = "id") long id) {
        return "chamada get" + id ;        
    }
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public String post(@RequestBody String body) {
        return "chamada post" + body;        
    }
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
    public String put() {
        return "chamada put";        
    }
 
    @RequestMapping(value = "/pessoa", method = RequestMethod.DELETE)
    public String delete() {
        return "chamada delete";        
    }
}
