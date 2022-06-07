package main.java.MigrantMatcher;

import java.util.Scanner;



public class MigrantMatcher {
	
	final String VOLUNATRIO = "volunatrio";
	final String MIGRANTE = "migrante";
	final String EXIT = "exit";
	
	private String getCommands() {
		String ret = "volunatrio - iniciar sessao como voluntario \n"
					+ "migrante - iniciar sessao como migrante \n"
					+ "exit - sair do programa \n";
						
		return ret;
	}
	
	private void Run() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			
			if(sc.nextLine().equals(VOLUNATRIO)) {
				//RUN VOL CODE
			}else if(sc.nextLine().equals(MIGRANTE)) {
				//RUN MIG CODE
			}else if(sc.nextLine().equals(EXIT)) {
				sc.close();
				break;
			}else {
				System.out.println("Comando nao existe por favor tente de novo");
			}
		}
	}
	
	
	
	public void main(String[] args) {
		getCommands();
		Run();
		
	}
}
