package main.java.Migrante;

import java.util.List;

import main.java.Ajuda.Ajuda;

public class Migrante {
    
    public String nome;
    public int contacto;
    public List<Ajuda> ajudasSelecionadas;

    public Migrante(String nome, int contacto){
        createMigrante(nome, contacto);
    }

    public void createMigrante(String nome, int contacto){
        this.nome = nome;
        this.contacto = contacto;
    }
    
    public List<Ajuda> getListAjudas(){
    	return ajudasSelecionadas;
    }
}
