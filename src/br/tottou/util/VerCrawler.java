package br.tottou.util;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
** @author Tottou - tottou@gmail.com
*/
public class VerCrawler {
	
	
	 public static String buscarVersao(String url)  {
				try {
					 Document document = Jsoup.connect(url)
							 .timeout(10000).validateTLSCertificates(false).get();
					 Elements metaTags = document.getElementsByTag("meta");
					 String content="Não foi possível encontrar.";
					 for (Element metaTag : metaTags) {
						 if (metaTag.attr("name").equals("generator")) {
							 content = metaTag.attr("content");
							 break;
						 	}						 
						}		
					 return content;
				} catch (HttpStatusException e) {
					// about bloqueado
					 return"Falha no acesso / bloqueado ";
				}						
				 catch (SocketTimeoutException e) {
					// timeout
					 return "Socket timeout";
				}
				 catch (IOException e) {
					// i/o
					 return "Falha de leitura ";
				}
			 
			  
	 }


}
