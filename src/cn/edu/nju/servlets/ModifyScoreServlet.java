package cn.edu.nju.servlets;

import java.io.File;  
import java.io.FileOutputStream;  
  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.xml.messaging.JAXMServlet;  
import javax.xml.messaging.ReqRespListener;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;  
import javax.xml.soap.SOAPMessage;

import cn.edu.nju.service.StudentScoreService;
import cn.edu.nju.serviceImpl.StudentScoreServiceImpl;

@WebServlet("/modify")
public class ModifyScoreServlet extends JAXMServlet implements ReqRespListener{
	private static final long serialVersionUID = 1L;  
    static MessageFactory mf = null;  
    // create a messagefactory  
    static {  
        try {  
            mf = MessageFactory.newInstance();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    };  
  
    /** 
     * @see JAXMServlet#JAXMServlet() 
     */  
    public ModifyScoreServlet() {  
        super();  

    }  
  
    /** 
     * @see ReqRespListener#onMessage(SOAPMessage) 
     */  
    public SOAPMessage onMessage(SOAPMessage msg) {  
        SOAPMessage resp = null;  
        try {  
            System.out.println("Received message：");  
            
           
            // create a response message  
            resp = mf.createMessage();  
            SOAPEnvelope se = resp.getSOAPPart().getEnvelope();
            SOAPBody sb=se.getBody();
            String term=sb.getElementsByTagName("成绩详情").item(0).getAttributes().item(0).getTextContent();
            String course=sb.getElementsByTagName("课程成绩").item(0).getAttributes().item(1).getTextContent();
            String type=sb.getElementsByTagName("课程成绩").item(0).getAttributes().item(0).getTextContent();
            String id=sb.getElementsByTagName("学号").item(0).getTextContent();
            String score=sb.getElementsByTagName("得分").item(0).getTextContent();
            
            System.out.println(score);
 
            se.getBody().addChildElement(se.createName("ResponseMessage"))  
                    .addTextNode("Received Message,Thanks");  
  
            return resp;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return resp;  
    }  
  
    /** 
     * @see Servlet#init(ServletConfig) 
     */  
    public void init(ServletConfig config) throws ServletException {  
  
        super.init(config);  
    }  
}
