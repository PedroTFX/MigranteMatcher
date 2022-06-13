package main.java.handlers;

import java.util.Scanner;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import main.java.Region;
import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Voluntario.CatalogoVoluntarios;
import main.java.Voluntario.Voluntario;

public class VoluntarioHandler {
	
	final String ITEM = "item";
	final String ALOJ = "alojamento";
	private Region reg;
	private Ajuda ajuda;
	private Voluntario voluntario;
	
	private void identificaVoluntario(int contacto) {
		if(!CatalogoVoluntarios.hasVoluntario(contacto)) {
			CatalogoVoluntarios.addNewVol(contacto);
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
		CatalogoAjudas.listAjudas.add(ajuda);
		scanner.close();
		
		PidgeonSMSSender sender = new PidgeonSMSSender();
		voluntario.setCodigo(CatalogoAjudas.listAjudas.size());
		sender.send(String.valueOf(voluntario.getContacto()), String.valueOf(voluntario.getCodigo()));
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
	
	boolean confirmarSMS(int codigo) {
		return codigo == voluntario.getCodigo();
	}
	
	public void runVoluntarioHandler() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indique o seu contacto telefonico");
			identificaVoluntario(sc.nextInt());
		System.out.println(" - Alojamento \n - Item");
			getTypeOfHelp(sc.nextLine());
		System.out.println("insira o codigo de confirmacao");
			confirmarSMS(voluntario.getCodigo());
		sc.close();
	}
	
}
