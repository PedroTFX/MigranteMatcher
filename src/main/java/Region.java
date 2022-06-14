package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.Ajuda.Ajuda;

public class Region {
    private final String[] listaRegioes = {  
    		 "Aveiro",
    		 "Beja",
    		 "Braga",
    		 "Bragança",
    		 "Castelo Branco",
    		 "Coimbra",
    		 "Evora",
    		 "Faro",
    		 "Guarda",
    		 "Leiria",
    		 "Lisboa",
    		 "Portalegre",
    		 "Porto",
    		 "Santarém",
    		 "Setubal",
    		 "Viana do Castelo",
    		 "Vila Real",
    		 "Viseu"};
      
      private static List<String> availableReg = new ArrayList<String>();
      
      public String selectedRegion;
      
      private boolean checkRegions(String reg) {
    	  for (String regiao : listaRegioes) {
			if(regiao.equals(reg)) {
				return true;
			}
		  }
    	  return false;
      }
      
      public String addRegion(String reg) {
    	  while(!checkRegions(reg)) {
    		  System.out.println("Regiao nao existe, tente uma de Portugal");
    		  reg = new Scanner(System.in).nextLine();
    	  }
    	  availableReg.add(reg);
    	  return reg;
      }
      
      public String[] getRegionsList(){
          return listaRegioes;
      }
}
