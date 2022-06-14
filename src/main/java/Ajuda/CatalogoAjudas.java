package main.java.Ajuda;

import java.util.ArrayList;
import java.util.List;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import main.java.Voluntario.Voluntario;

public class CatalogoAjudas {
    public static List<Ajuda> listAjudas = new ArrayList<Ajuda>();
    private static String defaultSMS = "Ajuda requisitada:";
    
    
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
            if(ajuda.tipoAjuda.equals("Item") || ajuda.regiao.equals(regiao)){
                ajudasReg.add(ajuda);
            }
        }
        return ajudasReg;
    }

    public static void removeAjudas(List<Ajuda> listaAjuda2){
    	
    	PidgeonSMSSender sender = new PidgeonSMSSender();
    	
        for (int i = 0; i < listAjudas.size();i++) {
            for (Ajuda ajuda2 : listaAjuda2) {
                if(checkAjuda(listAjudas.get(i), ajuda2)){
                	sender.send(String.valueOf(ajuda2.getVoluntario().getContacto()), defaultSMS + ajuda2.toString());
                	listAjudas.remove(ajuda2);
                }
            }
        }
    }
    
    private static boolean checkAjuda(Ajuda ajuda1,Ajuda ajuda2) {
    	if(ajuda1.getVoluntario().getContacto() == ajuda2.getVoluntario().getContacto()) {
    		if(ajuda1.toString().equals(ajuda2.toString())){
        		return true;
        	}
    	}
    	return false;
    }
    
    public static Ajuda getAjuda(String a) {
    	for (Ajuda ajuda : listAjudas) {
			if(ajuda.toString().equals(a)) {
				return ajuda;
			}
		}
    	System.out.println("A ajuda selecionada não se encontra na lista tente de novo");
    	return null;
    }
    
    public static boolean hasAjuda(String descOfHelp) {
    	for (Ajuda ajuda : listAjudas) {
			if(ajuda.toString().equals(descOfHelp)) {
				return true;
			}
		}
    	return false;
    }
}
