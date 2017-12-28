package cn.edu.nju.tool;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class StudentScoreTool {
	private static String filePath = "/Users/slow_time/eclipse-workspace/Assignment5/WebContent/DATA/";
	
	public static Document getStudentScoreList(String id) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(false);
		Document document = null;
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(filePath + id + ".xml");
		} 
		catch (FileNotFoundException e) {
//			e.printStackTrace();
		}catch (ParserConfigurationException e) {
//			e.printStackTrace();
		} catch (SAXException e) {
//			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		}
		return document;
	}
}
