package cn.edu.nju.serviceImpl;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import cn.edu.nju.service.StudentScoreService;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public SOAPMessage getStudentScoreById(String id) {
		try {
			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.setPrefix("env");
		} catch (SOAPException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
