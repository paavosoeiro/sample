package com.sample.samplews.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

// @SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{" + SampleNotFoundException.NAMESPACE_URI
//         + "}customFault", faultStringOrReason = "@faultString")
@SoapFault(faultCode = FaultCode.SERVER)
public class SampleNotFoundException extends Exception {
    protected static final String NAMESPACE_URI = "http://paavo.sample/samples";

    public SampleNotFoundException(String message) {
        super(message);
    }

}
