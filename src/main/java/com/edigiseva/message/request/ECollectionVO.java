package com.edigiseva.message.request;

import java.io.Serializable;

import com.edigiseva.model.VirtualAccountNumberVerificationIN;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ECollectionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4063199365856606454L;

	private VirtualAccountNumberVerificationIN virtualAccountNumberVerificationIN;

	public VirtualAccountNumberVerificationIN getVirtualAccountNumberVerificationIN() {
		return virtualAccountNumberVerificationIN;
	}

	public void setVirtualAccountNumberVerificationIN(
			VirtualAccountNumberVerificationIN virtualAccountNumberVerificationIN) {
		this.virtualAccountNumberVerificationIN = virtualAccountNumberVerificationIN;
	}

		
	
}
