package cn.edu.nju.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import cn.edu.nju.service.StudentScoreService;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public SOAPMessage getStudentScoreById(String id, ServletOutputStream out) {
		try {
			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.setPrefix("env");
			SOAPBody body = envelope.getBody();
			soapMessage.writeTo(out);
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
