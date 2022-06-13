package main.java.Voluntario;

import java.util.ArrayList;
import java.util.List;

import main.java.Migrante.Migrante;

public class CatalogoVoluntarios {
    public static List<Voluntario> Voluntarios = new ArrayList<Voluntario>();
    
    public static void addNewVol(int contacto){
        Voluntario v = new Voluntario(contacto);
        Voluntarios.add(v);
    }
    
    public static Voluntario getVoluntario(int contacto){
    	for(Voluntario voluntario : Voluntarios) {
    		if(voluntario.getContacto() == contacto) {
    			return voluntario;
    		}
    	}
    	return null;
    }
    
    public static boolean hasVoluntario(int contacto) {
    	return Voluntarios.contains(new Voluntario(contacto));
    }
}
