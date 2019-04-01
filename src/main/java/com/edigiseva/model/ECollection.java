package com.edigiseva.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ECollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 377742560558064122L;

	private String clientCode;
	private String virtulaAccNo;
	private String trxAmount;
	private String urtNo;
	private String senderIFSCCode;
	private String senderToReceiverInfo;
	private String rejectReason;
	private Date timestamp;
	private String paymentProductCode;
	private String trxRemark;
	private String status;

	public static final String STATUS_REJECT = "REJECT";
	public static final String STATUS_ACCEPT = "ACCEPT";
	
	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getVirtulaAccNo() {
		return virtulaAccNo;
	}

	public void setVirtulaAccNo(String virtulaAccNo) {
		this.virtulaAccNo = virtulaAccNo;
	}

	public String getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(String trxAmount) {
		this.trxAmount = trxAmount;
	}

	public String getUrtNo() {
		return urtNo;
	}

	public void setUrtNo(String urtNo) {
		this.urtNo = urtNo;
	}

	public String getSenderIFSCCode() {
		return senderIFSCCode;
	}

	public void setSenderIFSCCode(String senderIFSCCode) {
		this.senderIFSCCode = senderIFSCCode;
	}

	public String getSenderToReceiverInfo() {
		return senderToReceiverInfo;
	}

	public void setSenderToReceiverInfo(String senderToReceiverInfo) {
		this.senderToReceiverInfo = senderToReceiverInfo;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentProductCode() {
		return paymentProductCode;
	}

	public void setPaymentProductCode(String paymentProductCode) {
		this.paymentProductCode = paymentProductCode;
	}

	public String getTrxRemark() {
		return trxRemark;
	}

	public void setTrxRemark(String trxRemark) {
		this.trxRemark = trxRemark;
	}

	public ECollection() {
		// Default Constructor
	}

	public ECollection(String clientCode, String virtulaAccNo, String trxAmount, String urtNo, String senderIFSCCode,
			String senderToReceiverInfo, String rejectReason, Date timestamp, String paymentProductCode,
			String trxRemark, String status) {
		super();
		this.clientCode = clientCode;
		this.virtulaAccNo = virtulaAccNo;
		this.trxAmount = trxAmount;
		this.urtNo = urtNo;
		this.senderIFSCCode = senderIFSCCode;
		this.senderToReceiverInfo = senderToReceiverInfo;
		this.rejectReason = rejectReason;
		this.timestamp = timestamp;
		this.paymentProductCode = paymentProductCode;
		this.trxRemark = trxRemark;
		this.status = status;
	}

	// TODO : not good print values
	@Override
	public String toString() {
		return "ECollection [clientCode=" + clientCode + ", virtulaAccNo=" + virtulaAccNo + ", trxAmount=" + trxAmount
				+ ", urtNo=" + urtNo + ", senderIFSCCode=" + senderIFSCCode + ", senderToReceiverInfo="
				+ senderToReceiverInfo + ", rejectReason=" + rejectReason + ", timestamp=" + timestamp
				+ ", paymentProductCode=" + paymentProductCode + ", trxRemark=" + trxRemark + ", status=" + status
				+ "]";
	}
}
