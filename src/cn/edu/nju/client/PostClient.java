package cn.edu.nju.client;

import java.io.*;
import java.net.URL;  
  
import javax.xml.messaging.URLEndpoint;
import javax.xml.namespace.QName;
import javax.xml.soap.*;  

public class PostClient {
		/** 
	     * @param args 
	     * @throws SOAPException 
	     * @throws IOException 
	     */  
	    public static void main(String[] args) throws IOException, SOAPException {  
	        PostClient sender = new PostClient();
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        int index=0;
	        String[] params=new String[5];
	        String line=null;
	        while(!(line=br.readLine().trim()).equals("q")){
	        	params[index]=line;
	        	index++;
	        }
	        SOAPMessage message = sender.getMessage(params);  
	        sender.send(message);  
	    }  
	  
	    public void send(SOAPMessage message) throws IOException, SOAPException {  
	        // Create SOAP connection  
	        SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();  
	        SOAPConnection sc = scf.createConnection();  
	  
	        // Most article use this sentence which list below to specify the  
	        // endpoint, but I got error when I ran it.  
	        // URLEndpoint urlEndpoint = new URLEndpoint(  
	        // "http://localhost:8080/SOAP/ReceiveServlet");  
	  
	        // Specify the endpoint  
	        URL url = new URL("http://localhost:8080/Assignment5/modify");  
	  
	        // Send the SOAP message  
	        SOAPMessage response = sc.call(message, url);  
	  
	        if (response != null) {  
	            // Print the message to console  
	            System.out.println("Receive SOAP message from localhost:");  
	            response.writeTo(System.out);  
	        } else {  
	            System.err.println("No response received from partner!");  
	        }  
	  
	        sc.close();  
	  
	    }  
	  
	    public SOAPMessage getMessage(String[] params) throws SOAPException { 
	
	  
	        // Create a message factory  
	        MessageFactory mf = MessageFactory.newInstance();  
	        // Create a SOAP message  
	        SOAPMessage message = mf.createMessage();  
	  
	        SOAPEnvelope soapEnvelope = message.getSOAPPart().getEnvelope();
            soapEnvelope.addNamespaceDeclaration("tns", "http://jw.nju.edu.cn/schema");

            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement studentScore = soapBody.addChildElement(
                    soapBody.createQName("学生成绩", "tns"));

            SOAPElement scoreDetails = studentScore.addChildElement(
                    soapBody.createQName("成绩详情", "tns")).
                    addAttribute(new QName("学期"), params[0]);

            SOAPElement courseScoreList = scoreDetails.addChildElement(
                    soapBody.createQName("课程成绩列表", "tns"));

            SOAPElement courseScore = courseScoreList.addChildElement(
                    soapBody.createQName("课程成绩", "tns"));
            courseScore.addAttribute(new QName("成绩性质"), params[1]);
            courseScore.addAttribute(new QName("课程编号"), params[2]);

            SOAPElement grade = courseScore.addChildElement(
                    soapBody.createQName("成绩", "tns"));

            SOAPElement studentID = grade.addChildElement(
                    soapBody.createQName("学号", "tns"));
            studentID.addTextNode(params[3]);

            SOAPElement score = grade.addChildElement(
                    soapBody.createQName("得分", "tns"));
            score.addTextNode(params[4]);

            return message;
	    }  
	
}
