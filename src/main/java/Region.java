package main.java;

import java.util.List;
import java.util.Scanner;

import main.java.Ajuda.Ajuda;

public class Region {
    private final String[] listaRegioes = {  
    		 "Aveiro",
    		 "Beja",
    		 "Braga",
    		 "Bragan�a",
    		 "Castelo Branco",
    		 "Coimbra",
    		 "Evora",
    		 "Faro",
    		 "Guarda",
    		 "Leiria",
    		 "Lisboa",
    		 "Portalegre",
    		 "Porto",
    		 "Santar�m",
    		 "Setubal",
    		 "Viana do Castelo",
    		 "Vila Real",
    		 "Viseu"};
      
      private List<String> availableReg;
      
      public String selectedRegion;
      
      private boolean checkRegions(String reg) {
    	  for (String regiao : listaRegioes) {
			if(!regiao.equals(reg)) {
				return false;
			}
		  }
    	  return true;
      }
      
      public String addRegion(String reg) {
    	  while(!checkRegions(reg)) {
    		  System.out.println("Regiao nao existe, tente um  Portugal");
    		  reg = new Scanner(System.in).nextLine();
    	  }
    	  availableReg.add(reg);
    	  return reg;
      }
      
      public String[] getRegionsList(){
          return listaRegioes;
      }
}