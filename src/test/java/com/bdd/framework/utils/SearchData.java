package com.bdd.framework.utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * @author Hemanth.Sridhar
 */
public class SearchData {

	public static String propertiesReader(String Filename, String key) throws IOException{		
		FileReader reader = new FileReader(Filename);
		Properties properties = new Properties();
		properties.load(reader);
		String s = properties.getProperty(key);
		return s;	
	}
}
