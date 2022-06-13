package main.java.MigrantMatcher;

import java.util.Scanner;

import main.java.handlers.MigranteHandler;
import main.java.handlers.VoluntarioHandler;



public class MigrantMatcher {
	
	final String VOLUNATRIO = "volunatrio";
	final String MIGRANTE = "migrante";
	final String EXIT = "exit";
	
	private void getCommands() {
		String ret = "volunatrio - iniciar sessao como voluntario \n"
					+ "migrante - iniciar sessao como migrante \n"
					+ "exit - sair do programa \n";
		System.out.println(ret);				
	}
	
	private void Run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			getCommands();
			
			
			if(sc.nextLine().equals(VOLUNATRIO)) {
				VoluntarioHandler vHandler = new VoluntarioHandler();
				vHandler.runVoluntarioHandler();
			}else if(sc.nextLine().equals(MIGRANTE)) {
				MigranteHandler mHandler = new MigranteHandler();
				mHandler.runMigranteHandler();
			}else if(sc.nextLine().equals(EXIT)) {
				break;
			}else {
				System.out.println("Comando nao existe por favor tente de novo");
			}
		}
		sc.close();
	}
	
	public void main(String[] args) {
		getCommands();
		Run();
	}
}
