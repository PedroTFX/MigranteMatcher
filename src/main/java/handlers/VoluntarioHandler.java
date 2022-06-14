package main.java.handlers;

import java.util.Scanner;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import main.java.Region;
import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Voluntario.CatalogoVoluntarios;
import main.java.Voluntario.Voluntario;

public class VoluntarioHandler {
	
	final String ITEM = "Item";
	final String ALOJ = "Alojamento";
	public Ajuda ajuda;
	private Voluntario voluntario;
	
	private void identificaVoluntario(int contacto) {
		if(!CatalogoVoluntarios.hasVoluntario(contacto)) {
			CatalogoVoluntarios.addNewVol(contacto);
    	}
		voluntario = CatalogoVoluntarios.getVoluntario(contacto);
	}
	
	void getTypeOfHelp(String tipoAjuda) {
		
		if(tipoAjuda.equals(ITEM)) {
			ajuda = new Ajuda(ITEM);
			ajuda.vol = voluntario;
			System.out.println("Indique o uma breve descricao do item:");
			String desc = new Scanner(System.in).nextLine();
			item(desc);
			
		}else if(tipoAjuda.equals(ALOJ)){
			ajuda = new Ajuda(ALOJ);
			ajuda.vol = voluntario;
			System.out.println("Indique o numero max de pessoas para o alojamento:");
			int numPessoas = new Scanner(System.in).nextInt();
			giveAloj(numPessoas);
			
			System.out.println("Indique a regiao do alojamento:");
			String regiao = new Scanner(System.in).nextLine();
			setRegiao(regiao);
			
		}
		PidgeonSMSSender sender = new PidgeonSMSSender();
		voluntario.setCodigo(CatalogoAjudas.listAjudas.size());
		sender.send(String.valueOf(voluntario.getContacto()), String.valueOf(voluntario.getCodigo()));
	}
	
	void setRegiao(String regiao) {
		ajuda.setRegiao(new Region().addRegion(regiao));
		
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
		System.out.println("Indique o seu contacto telefonico");
			int contacto = new Scanner(System.in).nextInt();
			identificaVoluntario(contacto);
		System.out.println("Pretende oferecer qual tipo de ajuda? \n - Alojamento \n - Item");
			String typeOfHelp = new Scanner(System.in).nextLine();
			getTypeOfHelp(typeOfHelp);
		System.out.println("Insira o codigo de confirmacao");
			int codigo = new Scanner(System.in).nextInt();
			if(confirmarSMS(codigo)) {
				CatalogoAjudas.listAjudas.add(ajuda);
				System.out.println("Adicionou a ajuda :" + ajuda.toString() + ", com sucesso!");
			}else {
				System.out.println("Better luck next time introducing the code");
			}
	}
	
}
