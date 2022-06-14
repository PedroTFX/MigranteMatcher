package main.java.Migrante;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMigrantes {
    public static List<Migrante> Migrantes = new ArrayList<Migrante>();

    public static void addMigrante(String nome, int contacto){
        Migrante m = new Migrante(nome, contacto);
        Migrantes.add(m);
    }
    
    public static Migrante getMigrante(String nome, int contacto) {
    	for (Migrante migrante : Migrantes) {
			if(migrante.contacto == contacto && migrante.nome.equals(nome)) {
				return migrante;
			}
		}
    	return null;
    }
    
    public static List<Migrante> getMigrante(int contacto) {
    	List<Migrante> familia = new ArrayList<Migrante>();
    	for (Migrante migrante : Migrantes) {
			if(migrante.contacto == contacto) {
				familia.add(migrante);
			}
		}
    	return familia;
    }
    
    public static boolean hasMigrante(String nome, int contacto) {
    	for (Migrante migrante : Migrantes) {
			if(migrante.nome.equals(nome) && migrante.contacto == contacto) {
				return true;
			}
		}
    	return false;
    }
}