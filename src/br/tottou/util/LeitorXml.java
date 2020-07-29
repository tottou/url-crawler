package br.tottou.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
** @author Tottou - tottou@gmail.com
*/
public class LeitorXml {

	
	 public static Set<String> fetchUrl(String xml) throws Exception {
		 Set<String> listaUrl = new HashSet<String>();
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xml));
	        NodeList nodeList = document.getElementsByTagName("property");
	        String value="";
	        for(int x=0,size= nodeList.getLength(); x<size; x++) {
	        	if (nodeList.item(x).getAttributes().getNamedItem("value")!=null)
	        		value = nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue();
	        		if (value.contains("http")) {
	        			listaUrl.add(value);
	        		}
	        }
	        
	       return listaUrl;
	    }

}
