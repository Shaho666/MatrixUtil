package com.example.matrixui.uiframe;

import java.io.File;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.matrixui.pageswitch.Page;

public class PageInstanceInterface {

	private static Page page = null;
	
	public static Page getPage(String classnameinxml) {
		
		try {
			
			File file = new File("src/com/example/matrixui/pagechange.xml");
			
			if(!file.exists())
				file = new File("pagechange.xml");
				
			SAXReader reader = new SAXReader();
			
			org.dom4j.Document doc = reader.read(file);
			
			Element root = doc.getRootElement();
			
			String className = root.elementText(classnameinxml).trim();
			
			page = (Page) Class.forName(className).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	}
	
}
