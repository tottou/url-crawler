package br.tottou.main;

import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;



import br.tottou.util.LeitorXml;
import br.tottou.util.VerCrawler;


/**
* Busca no titledb endereços e recuera versão do OJS
* 
*
* @author Tottou - tottou@gmail.com
*/

public class CheckOJSVersion {
	 public static void main(String[] args) throws Exception {
		 Set<String> listaVersoes = new HashSet<String>(); 
		 Set<String> listaUrl = LeitorXml.fetchUrl("d:\\titledb.xml");
		 String versao = "";
		 
		 for (String url : listaUrl) {
			 System.out.println("Buscando versão no endereço: "+url);
			 versao=VerCrawler.buscarVersao(url);
			 listaVersoes.add(url +" - "+versao);			 
			 
		 }
		 
		 	 
			 FileWriter writer = new FileWriter("d:\\versao_ojs.txt"); 
			 for(String str: listaVersoes) {
			   writer.write(str);
			   writer.write("\n");
			 }
			 writer.close();
			 System.out.println("Processo finalizado.");
	  
	 }

}
