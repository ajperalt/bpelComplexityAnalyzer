package com.a4bp.integration.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.a4bp.integration.soap.model.BpObject;
import com.a4bp.integration.soap.model.BpObjectResp;

/**
 * 
 * @author alvarojose
 * 
 */
@WebService
public class A4bpInstrumentation {

	@WebMethod
	public BpObjectResp afterExecution(BpObject bpObject) {
		return null;
	}

	@WebMethod
	public BpObjectResp beforeExecution(BpObject bpObject) {
		return null;
	}
}
