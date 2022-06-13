package main.java.handlers;

import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Migrante.CatalogoMigrantes;
import main.java.Migrante.Migrante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import main.java.Region;

public class MigranteHandler {
	
    private Region reg = new Region();
    private List<Ajuda> listAjudas;
    private Migrante m;
    private int contacto = -1;
    
    public int numPessoas;


    public void indentificaMigrante(String nome, int contacto) {
		if(!CatalogoMigrantes.hasMigrante(nome, contacto)) {
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
    	List<Ajuda> list = CatalogoAjudas.getAjudasFilter(regiao, m.getAjudas());
    	
    	for(Ajuda ajuda : list) {
    		System.out.println(ajuda.toString());
    	}
    }
    
    public void escolherAjuda(Ajuda ajuda) {
    	listAjudas.add(ajuda);
    	System.out.println("*Ajuda adicionada a sua lista");
    }
    
    public void confirmar() {
    	List<Migrante> allMembersList = new ArrayList<Migrante>();
    	for (Migrante migrante : allMembersList) {
    		for (Ajuda a : listAjudas) {
    			migrante.ajudasSelecionadas.add(a);
    			sendSMS(a.getVoluntario().getContacto(), "A ajuda:" + a.toString() + "foi requisitada");
			}
		}
    	CatalogoAjudas.removeAjudas(listAjudas);
    }
    
    public void sendSMS(int contacto, String mensagem) {
    	PidgeonSMSSender sender = new PidgeonSMSSender();
    	sender.send(String.valueOf(contacto), mensagem);
    }
    
    public void runMigranteHandler() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indique o seu nome e contacto telefonico ou \"familia *numero de pessoas*\" ");
			String[] temp = sc.nextLine().split(" ");
			if(temp[0].equals("familia")) {
				System.out.println("Indique o nome do cabeça de casal");
				String nome = sc.nextLine();
				System.out.println("Indique o do cabeça de casal");
				contacto = sc.nextInt();
				cabeçaDeCasal(nome, contacto);
				for(int i = 0; i < Integer.parseInt(temp[1]); i++) {
					System.out.println("Indique o nome do prox. membro");
					nome = sc.nextLine();
					registaMembro(nome);
				}
			}else {
				indentificaMigrante(temp[0], Integer.parseInt(temp[1]));
			}
			System.out.println("Select one of the options: \n - lista de regioes");
			pedirRegioes();
			indicaRegiao(sc.nextLine());
			System.out.println("Escreva exatamente o que quer(dica: copie a ajuda da lista ;) ) \n Para confirmar escreva \"confirmar\" ");
			String temp2 = "";
			while(!temp2.equals("confirmar")) {
				escolherAjuda(CatalogoAjudas.getAjuda(temp2));
				temp2 = sc.nextLine();
			}
			confirmar();
			
		sc.close();
	}

}
