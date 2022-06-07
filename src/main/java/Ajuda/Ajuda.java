package main.java.Ajuda;

import main.java.Voluntario.Voluntario;

public class Ajuda {

    public Voluntario vol;
    public String tipoAjuda, descricao, regiao;
    public int numPessoas;

    public Ajuda(String tipoAjuda){
        this.tipoAjuda = tipoAjuda;
        if(tipoAjuda.equals("item")){
            numPessoas = -1;
        }else if(tipoAjuda.equals("alojamento")){
            descricao = null;
        }
    }

    public Voluntario getVoluntario(){
        return vol;
    }

    public void createAjuda(String tipoAjuda){
        CatalogoAjudas.addAjuda(new Ajuda(tipoAjuda));
    }

    public String toString(){
        String ret = (tipoAjuda.equals("item")) ? 
         "Item - Descricao: " + descricao :
         "Alojamento - numero de Pessoas: " + numPessoas;
        return ret;
    }
}