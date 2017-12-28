package cn.edu.nju.servlets;

import java.io.File;  
import java.io.FileOutputStream;  
  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.xml.messaging.JAXMServlet;  
import javax.xml.messaging.ReqRespListener;  
import javax.xml.soap.MessageFactory;  
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
            msg.writeTo(new FileOutputStream(new File(  
                    "./soapmessage.xml")));
  
            // create a response message  
            resp = mf.createMessage();  
            SOAPEnvelope se = resp.getSOAPPart().getEnvelope();  
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
