package main.java.Ajuda;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAjudas {
    public static List<Ajuda> listAjudas = new ArrayList<Ajuda>();

    public static void addAjuda(Ajuda a){
        listAjudas.add(a);
    }

    public void setCapacity(int numPessoas, Ajuda ajuda){
        ajuda.numPessoas = numPessoas;
    }

    public void setDescricao(String descicao, Ajuda ajuda){
        ajuda.descricao = descicao;
    }

    public void setRegion(String regiao, Ajuda ajuda){
        ajuda.regiao = regiao;
    }

    public static List<Ajuda> getAjudasFilter(String regiao, List<Ajuda> ajudas){
        List<Ajuda> ajudasReg = new ArrayList<Ajuda>();
        for (Ajuda ajuda : listAjudas) {
            if(ajuda.toString().equals("item") || ajuda.toString().equals(regiao)){
                ajudasReg.add(ajuda);
            }
        }        
        removeAjudas(ajudasReg, ajudas);
        return ajudasReg;
    }

    public static void removeAjudas(List<Ajuda> listaAjuda1, List<Ajuda> listaAjuda2){
        for (Ajuda ajuda1 : listaAjuda1) {
            for (Ajuda ajuda2 : listaAjuda2) {
                if(ajuda1.toString().equals(ajuda2.toString())){
                    listaAjuda1.remove(ajuda2);
                }
            }
        }
    }
}
