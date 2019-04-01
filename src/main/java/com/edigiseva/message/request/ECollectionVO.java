package com.edigiseva.message.request;

import java.io.Serializable;
import java.util.List;

import com.edigiseva.model.ECollection;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ECollectionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4063199365856606454L;

	private List<ECollection> eCollections;

	public List<ECollection> geteCollections() {
		return eCollections;
	}

	public void seteCollections(List<ECollection> eCollections) {
		this.eCollections = eCollections;
	}

	public ECollectionVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ECollectionVO(List<ECollection> eCollections) {
		super();
		this.eCollections = eCollections;
	}

}
