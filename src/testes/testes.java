package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.Ajuda.Ajuda;
import main.java.Ajuda.CatalogoAjudas;
import main.java.Migrante.CatalogoMigrantes;
import main.java.Voluntario.CatalogoVoluntarios;
import main.java.Voluntario.Voluntario;
import main.java.handlers.MigranteHandler;
import main.java.handlers.VoluntarioHandler;

public class testes {

	
	@Test
	void createVoluntario() {
		CatalogoVoluntarios.addNewVol(0);
		assertEquals(CatalogoVoluntarios.hasVoluntario(0), true);
	}
	
	@Test
	void createMigrante() {
		CatalogoMigrantes cMigrantes = new CatalogoMigrantes();
		cMigrantes.addMigrante("Ambrosio", 0);
		assertEquals(true, cMigrantes.hasMigrante("Ambrosio", 0));
	}
	
	@Test
	void createFamilia() {
		String cabeçaDeCasal = "Ambrosio";
		String mem1 = "marta";
		String mem2 = "martim";
		String mem3 = "marionete";
		String mem4 = "mario";
		int contacto = 0;
		MigranteHandler migranteHandler = new MigranteHandler();
		migranteHandler.cabeçaDeCasal(cabeçaDeCasal, contacto);
		migranteHandler.registaMembro(mem1);
		migranteHandler.registaMembro(mem2);
		migranteHandler.registaMembro(mem3);
		migranteHandler.registaMembro(mem4);
		assertEquals(CatalogoMigrantes.hasMigrante("Ambrosio", 0), true);
		assertEquals(CatalogoMigrantes.hasMigrante("marta", 0), true);
		assertEquals(CatalogoMigrantes.hasMigrante("martim", 0), true);
		assertEquals(CatalogoMigrantes.hasMigrante("marionete", 0), true);
		assertEquals(CatalogoMigrantes.hasMigrante("mario", 0), true);
	}
	
	@Test
	void addAjudaItem() {
		Ajuda ajuda = new Ajuda("Item");
		ajuda.vol = new Voluntario(0);
		ajuda.descricao = "Undercover Martyn - Two Door Cinema Club";
		CatalogoAjudas.addAjuda(ajuda);
		assertEquals(true, CatalogoAjudas.hasAjuda(ajuda.toString()));
	}
	
	@Test
	void addAjudaAloj() {
		Ajuda ajuda = new Ajuda("Alojamento");
		ajuda.setRegiao("Beja");
		ajuda.numPessoas = 11;
		ajuda.vol = new Voluntario(0);
		CatalogoAjudas.addAjuda(ajuda);
		assertEquals(true, CatalogoAjudas.hasAjuda(ajuda.toString()));
	}
	
	@Test
	void removeHelp() {
		Ajuda ajuda = new Ajuda("Alojamento");
		ajuda.setRegiao("Beja");
		ajuda.numPessoas = 10;
		ajuda.vol = new Voluntario(0);
		CatalogoAjudas.addAjuda(ajuda);
		assertEquals(CatalogoAjudas.hasAjuda(ajuda.toString()), true);
		List<Ajuda> listAjudas = new ArrayList<Ajuda>();
		listAjudas.add(ajuda);
		CatalogoAjudas.removeAjudas(listAjudas);
		assertEquals(false, CatalogoAjudas.hasAjuda(ajuda.toString()));
	}
	
	
	
	
}
