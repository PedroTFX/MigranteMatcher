package main.java.Voluntario;

import java.util.ArrayList;
import java.util.List;

public class CatalogoVoluntarios {
    public static List<Voluntario> listVoluntario = new ArrayList<Voluntario>();
    
    public static void addNewVol(int contacto){
        Voluntario v = new Voluntario(contacto);
        listVoluntario.add(v);
    }
    
    public static Voluntario getVoluntario(int contacto){
    	for(Voluntario voluntario : listVoluntario) {
    		if(voluntario.contacto == contacto) {
    			return voluntario;
    		}
    	}
    	return null;
    }
}
