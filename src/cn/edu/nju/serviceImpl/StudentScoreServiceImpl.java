package cn.edu.nju.serviceImpl;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Document;



import cn.edu.nju.service.StudentScoreService;
import cn.edu.nju.tool.StudentScoreTool;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public void getStudentScoreById(String id, ServletOutputStream out) {
		try {
			SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.setPrefix("env");
			SOAPBody body = envelope.getBody();
			Document document = StudentScoreTool.getStudentScoreList(id);
			if (document != null) {
				body.addDocument(document);
			}
			else {
				SOAPFault soapFault = body.addFault();
				soapFault.addFaultReasonText("No such Student", Locale.ENGLISH);
			}
			soapMessage.writeTo(out);
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyStudentScore() {
		// TODO Auto-generated method stub
	}

}
