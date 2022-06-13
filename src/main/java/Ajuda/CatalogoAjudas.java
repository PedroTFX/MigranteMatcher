package main.java.Ajuda;

import java.util.ArrayList;
import java.util.List;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

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
            if(ajuda.tipoAjuda.equals("item") || ajuda.regiao.equals(regiao)){
                ajudasReg.add(ajuda);
            }
        }
        return ajudasReg;
    }

    public static void removeAjudas(List<Ajuda> listaAjuda2){
    	
    	PidgeonSMSSender sender = new PidgeonSMSSender();
    	
        for (Ajuda ajuda1 : listAjudas) {
            for (Ajuda ajuda2 : listaAjuda2) {
                if(checkAjuda(ajuda1, ajuda2)){
                	sender.send(String.valueOf(ajuda2.getVoluntario().getContacto()), defaultSMS + ajuda2.toString());
                	listAjudas.remove(ajuda2);
                }
            }
        }
    }
    
    private static boolean checkAjuda(Ajuda ajuda1,Ajuda ajuda2) {
    	if(ajuda1.getVoluntario().getContacto() != ajuda1.getVoluntario().getContacto()) {
    		return false;
    	}
    	if(!ajuda1.getDescricao().equals(ajuda2.getDescricao())) {
    		return false;
    	}
    	if(ajuda1.getNumPessoas() != ajuda2.getNumPessoas()) {
    		return false;
    	}
    	if(ajuda1.getType().equals(ajuda2.getType())) {
    		return false;
    	}
    	
    	return true;
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
}
