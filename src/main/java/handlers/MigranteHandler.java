package main.java.handlers;

import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Migrante.CatalogoMigrantes;
import main.java.Migrante.Migrante;
import main.java.Voluntario.Voluntario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.Region;

public class MigranteHandler {
	
    private Region reg = new Region();
    private List<Ajuda> listAjudas;
    private Migrante m;
    private int contacto = -1;
    
    public int numPessoas;


    public void indentificaMigrante(String nome, int contacto) {
    	Migrante migrante;
		if((migrante = CatalogoMigrantes.getMigrante(nome, contacto)) != null) {
    		CatalogoMigrantes.addMigrante(nome, contacto);
    		listAjudas = new ArrayList<Ajuda>();
    	}
    }
    
    public void indentificaMigrante(int numPessoas) {
    	this.numPessoas = numPessoas;
    }
    
    public void cabeçaDeCasal(String nome, int contacto) {
    	indentificaMigrante(nome, contacto);
    	this.contacto = contacto;
    }
    
    public void registaMembro(String nome) {
    	indentificaMigrante(nome, contacto);
    }
    
    public void pedirRegioes() {
    	Scanner scanner = new Scanner(System.in);
		System.out.println("Opcoes: \n 1 - obter lista de regioes");
    	while(scanner.nextInt() != 1) {
    		System.out.println("Opcao invalida tente outra vez");
    	}
		System.out.println(reg.getRegionsList());
		
    	scanner.close();
    }
    
    public void indicaRegiao(String regiao) {
    	reg.selectedRegion = regiao;
    	
    	System.out.println("Ajudas disponiveis:");
    	List<Ajuda> list = CatalogoAjudas.getAjudasFilter(regiao, m.getListAjudas());
    	
    	for(Ajuda ajuda : list) {
    		System.out.println(ajuda.toString());
    	}
    }
    
    public void escolherAjuda(Ajuda ajuda) {
    	listAjudas.add(ajuda);
    }
    
    public void confirmar() {
    	if(contacto != -1) {
    		List<Migrante> familia = CatalogoMigrantes.getMigrante(contacto);
    		contacto = -1;
    		for (Migrante migrante : familia) {
    			for(Ajuda a : listAjudas) {
    				migrante.ajudasSelecionadas.add(a);
            	}
			}
    	}else {
    		for(Ajuda a : listAjudas) {
        		m.ajudasSelecionadas.add(a);
        	}
    	}
    	CatalogoAjudas.removeAjudas(m.getListAjudas());
    }
    public void sendSMS(int contacto, String mensagem);

}
