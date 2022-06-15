package main.java.handlers;

import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Migrante.CatalogoMigrantes;
import main.java.Migrante.Migrante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    	}
		listAjudas = new ArrayList<Ajuda>();
		m = CatalogoMigrantes.getMigrante(nome, contacto);
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
		System.out.println("1 - obter lista de regioes");
		int temp = new Scanner(System.in).nextInt();
    	while(temp != 1) {
    		System.out.println("Opcao invalida tente outra vez");
    		temp = new Scanner(System.in).nextInt();
    	}
		System.out.println(Arrays.toString(reg.getRegionsList()));
    }
    
    public void indicaRegiao(String regiao) {
    	reg.selectedRegion = regiao;
    	
    	System.out.println("Ajudas disponiveis:");
    	List<Ajuda> list = CatalogoAjudas.getAjudasFilter(regiao, m.getAjudas());
    	
    	for(Ajuda ajuda : list) {
    		System.out.println(ajuda.toString());
    	}
    	System.out.println("");
    }
    
    public void escolherAjuda(Ajuda ajuda) {
    	listAjudas.add(ajuda);
    	System.out.println("*Ajuda adicionada a sua lista");
    }
    
    public void confirmar() {
    	List<Migrante> allMembersList = CatalogoMigrantes.getMigrante(contacto);
    	for (Migrante migrante : allMembersList) {
    		for (Ajuda a : listAjudas) {
    			migrante.ajudasSelecionadas.add(a);
			}
		}
    	CatalogoAjudas.removeAjudas(listAjudas);
    }
    
    public void sendSMS(int contacto, String mensagem) {
    	PidgeonSMSSender sender = new PidgeonSMSSender();
    	sender.send(String.valueOf(contacto), mensagem);
    }
    
    public void runMigranteHandler() {
		System.out.println("Indique o seu *nome contacto* ou \"familia *numero de pessoas*\" ");
			String[] temp = new Scanner(System.in).nextLine().split(" ");
			while(temp.length <= 1 || temp.length > 2) {
					System.out.println("*algo de errado nao esta certo tente de novo*");
					System.out.println("Indique o seu *nome contacto* ou \"familia *numero de pessoas*\" ");
				temp = new Scanner(System.in).nextLine().split(" ");
			}
			if(temp[0].equals("familia")) {
					System.out.println("Indique o nome do cabeça de casal");
				String nome = new Scanner(System.in).nextLine();
					System.out.println("Indique o contacto do cabeça de casal");
				int contacto = -1;
				while(contacto == -1) {
					String contc = new Scanner(System.in).nextLine();
					try {
						contacto = Integer.parseInt(contc);
					} catch (NumberFormatException e) {
					    System.out.println("*isso nao é um numero tenta outra vez*");
					}
				}
				cabeçaDeCasal(nome, contacto);
				for(int i = 0; i < Integer.parseInt(temp[1]); i++) {
						System.out.println("Indique o nome do prox. membro");
					nome = new Scanner(System.in).nextLine();
					registaMembro(nome);
				}
			}else {
				indentificaMigrante(temp[0], Integer.parseInt(temp[1]));
			}
			System.out.println("Selecione uma das opções por numero:");
			pedirRegioes();
			String reg = new Scanner(System.in).nextLine();
			indicaRegiao(reg);
			System.out.println("Escreva exatamente o que quer(dica: copie a ajuda da lista ;) ) \nPara confirmar escreva \"confirmar\" ");
			String temp2 = "";
			while(!temp2.equals("confirmar")) {
				if(CatalogoAjudas.hasAjuda(temp2)) {
					escolherAjuda(CatalogoAjudas.getAjuda(temp2));
				}else {
					System.out.println("selecione uma opção da lista");
				}
				temp2 = new Scanner(System.in).nextLine();
			}
			confirmar();
	}

}
