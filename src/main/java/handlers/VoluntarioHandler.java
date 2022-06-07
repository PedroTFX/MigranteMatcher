package main.java.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.Region;
import main.java.Ajuda.Ajuda;
import main.java.Migrante.CatalogoMigrantes;
import main.java.Voluntario.CatalogoVoluntarios;
import main.java.Voluntario.Voluntario;

public class VoluntarioHandler {
	
	private List<Ajuda> listAjudas;
	final String ITEM = "item";
	final String ALOJ = "alojamento";
	private Region reg;
	private Ajuda ajuda;
	private Voluntario voluntario;
	
	void indentificaVoluntario(int contacto) {
		if((voluntario = CatalogoVoluntarios.getVoluntario(contacto)) != null) {
			CatalogoVoluntarios.addNewVol(contacto);
    		listAjudas = new ArrayList<Ajuda>();
    	}
	}
	
	void getTypeOfHelp(String tipoAjuda) {
		ajuda.vol = voluntario;
		Scanner scanner = new Scanner(System.in);
		
		if(tipoAjuda.equals(ITEM)) {
			ajuda = new Ajuda(ITEM);
			
			System.out.println("Indique o uma breve descricao do item:");
			item(scanner.nextLine());
			
		}else if(tipoAjuda.equals(ALOJ)){
			ajuda = new Ajuda(ALOJ);
			
			System.out.println("Indique o numero max de pessoas para o alojamento:");
			giveAloj(scanner.nextInt());
			
			System.out.println("Indique a regiao do alojamento:");
			setRegiao(scanner.nextLine());
			
		}
		listAjudas.add(ajuda);
		scanner.close();
	}
	
	void setRegiao(String regiao) {
		ajuda.regiao = reg.addRegion(regiao);
		
	}
	
	void item(String descricao) {
		ajuda.descricao = descricao;
	}
	
	void giveAloj(int numPessoas) {
		ajuda.numPessoas = numPessoas;
	}
	
	void confirmarSMS(int codigo);
	
}
