package main.java.MigrantMatcher;

import java.util.Scanner;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import main.java.handlers.MigranteHandler;
import main.java.handlers.VoluntarioHandler;

public class MigrantMatcher {
	
	final static String VOLUNTARIO = "voluntario";
	final static String MIGRANTE = "migrante";
	final static String EXIT = "exit";
	
	private static void getCommands() {
		String ret = "volunatrio - iniciar sessao como voluntario \n"
					+ "migrante - iniciar sessao como migrante \n"
					+ "exit - sair do programa \n";
		System.out.println(ret);				
	}
	
	private static void Run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if(input.equals(VOLUNTARIO)) {
				VoluntarioHandler vHandler = new VoluntarioHandler();
				vHandler.runVoluntarioHandler();
			}else if(input.equals(MIGRANTE)) {
				MigranteHandler mHandler = new MigranteHandler();
				mHandler.runMigranteHandler();
			}else if(input.equals(EXIT)) {
				break;
			}else {
				System.out.println("Comando nao existe por favor tente de novo");
			}
			getCommands();
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		getCommands();
		Run();
	}
}
