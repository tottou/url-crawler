package br.tottou.main;

import java.io.FileWriter;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
* Busca no titledb endere�os e recuera vers�o do OJS
* 
*
* @author Tottou - tottou@gmail.com
*/

public class CheckOJSVersion {
	 public static void main(String[] args) throws Exception {
	        String prefixo = "https://www.revistas.ufg.br/revistaufg/";
	        String handle = "about/aboutThisPublishingSystem";
			 List<String> urls = new ArrayList<String>();
				try {
					 Document document = Jsoup.connect(prefixo+handle)
							 .timeout(10000).validateTLSCertificates(false).get();
					 Elements metaTags = document.getElementsByTag("meta");
					 String content="N�o foi poss�vel encontrar.";
					 for (Element metaTag : metaTags) {
						 if (metaTag.attr("name").equals("generator")) {
							 content = metaTag.attr("content");
							 break;
						 	}						 
						}					 
					 
					 urls.add("Vers�o:"+content);
				} catch (HttpStatusException e) {
					// about bloqueado
					 urls.add("Falha ao tentar acessar: "+prefixo+handle);
				}						
				 catch (SocketTimeoutException e) {
					// timeout
					 urls.add("Socket timeout: "+prefixo+handle);
				}	
			 
			 FileWriter writer = new FileWriter("d:\\ItensProd.txt"); 
			 for(String str: urls) {
			   writer.write(str);
			   writer.write("\n");
			 }
			 writer.close();
	
	  
	 }

}
