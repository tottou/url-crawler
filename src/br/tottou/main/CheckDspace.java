package br.tottou.main;

import java.io.FileWriter;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.tottou.dao.HandleDAO;
import br.tottou.entity.Handle;

/**
* Busca todos os itens pelos handles do banco e identifica falhas
* 
*
* @author Tottou - tottou@gmail.com
*/

public class CheckDspace {
	 public static void main(String[] args) throws Exception {
	        String prefixo = "http://localhost:8080/xmlui/handle/";
	        HandleDAO dao = new HandleDAO();
			 List<Handle> lista = dao.getAllHandle();
			 List<String> urls = new ArrayList<String>();
			 int c=1;
			 for (Handle handle: lista){
				 System.out.println(c+"-"+prefixo+handle.getHandle());
				 c++;
				try {
					 Document document = Jsoup.connect(prefixo+handle.getHandle()).get();
					 String item = document.select("#file_list").text();	
					 String colecao = document.select("#aspect_artifactbrowser_CollectionViewer_div_collection-view").text();
					 String comunidade = document.select("#aspect_artifactbrowser_CommunityViewer_div_community-view").text();
				        if (item.isEmpty()&&comunidade.isEmpty()&&colecao.isEmpty()){				        
				        		urls.add(prefixo+handle.getHandle());				        	
				        }
				} catch (HttpStatusException e) {
					// Handles no banco mas não existem itens
					// urls.add("httpE"+prefixo+handle.getHandle());
				}						
				 catch (SocketTimeoutException e) {
					// timeout
					 urls.add("timetout"+prefixo+handle.getHandle());
				}	
			 }
			 
			 FileWriter writer = new FileWriter("d:\\ItensProd.txt"); 
			 for(String str: urls) {
			   writer.write(str);
			   writer.write("\n");
			 }
			 writer.close();
	
	  
	 }

}
