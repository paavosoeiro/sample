package com.sample.samplews.exception;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import sample.paavo.samples.GetSampleFault;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("statusCode");
    private static final QName MESSAGE = new QName("message");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {


        try {
            JAXBContext newInstance = JAXBContext.newInstance(GetSampleFault.class);
            Marshaller createMarshaller = newInstance.createMarshaller();
            if (ex instanceof ServiceFaultException serviceException) {
                var serviceStatus = serviceException.getServiceStatus();
                GetSampleFault getSampleFault = new GetSampleFault();
                getSampleFault.setError(serviceStatus);
                // var detail = fault.addFaultDetail();
                // detail.addFaultDetailElement(new QName("getSampleFault"));
                // detail.addFaultDetailElement(CODE).addText(serviceStatus.getStatusCode());
                // detail.addFaultDetailElement(MESSAGE).addText(serviceStatus.getMessage());

                createMarshaller.marshal(getSampleFault, fault.addFaultDetail().getResult());
    
            }
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
