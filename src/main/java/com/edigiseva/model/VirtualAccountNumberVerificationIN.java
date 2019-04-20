package com.edigiseva.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VirtualAccountNumberVerificationIN implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 377742560558064122L;

	private String clientCode;
	private String virtualAccountNumber;
	private String transactionAmount;
	private Date transactionDateAndTime;
	private String utrNo;
	private String remitterName;
	private String remitterAccountNumber;
	private String remitterIFSCCode;
	private String paymentMode;
	private String senderToReceiverInformation;
	private String transactionRemark;
	private String rejectReason;
	private String status;
	
	public static final String STATUS_REJECT = "REJECT";
	public static final String STATUS_ACCEPT = "ACCEPT";
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getVirtualAccountNumber() {
		return virtualAccountNumber;
	}
	public void setVirtualAccountNumber(String virtualAccountNumber) {
		this.virtualAccountNumber = virtualAccountNumber;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDateAndTime() {
		return transactionDateAndTime;
	}
	public void setTransactionDateAndTime(Date transactionDateAndTime) {
		this.transactionDateAndTime = transactionDateAndTime;
	}
	public String getUtrNo() {
		return utrNo;
	}
	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}
	public String getRemitterName() {
		return remitterName;
	}
	public void setRemitterName(String remitterName) {
		this.remitterName = remitterName;
	}
	public String getRemitterAccountNumber() {
		return remitterAccountNumber;
	}
	public void setRemitterAccountNumber(String remitterAccountNumber) {
		this.remitterAccountNumber = remitterAccountNumber;
	}
	public String getRemitterIFSCCode() {
		return remitterIFSCCode;
	}
	public void setRemitterIFSCCode(String remitterIFSCCode) {
		this.remitterIFSCCode = remitterIFSCCode;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getSenderToReceiverInformation() {
		return senderToReceiverInformation;
	}
	public void setSenderToReceiverInformation(String senderToReceiverInformation) {
		this.senderToReceiverInformation = senderToReceiverInformation;
	}
	public String getTransactionRemark() {
		return transactionRemark;
	}
	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public VirtualAccountNumberVerificationIN(String clientCode, String virtualAccountNumber, String transactionAmount,
			Date transactionDateAndTime, String utrNo, String remitterName, String remitterAccountNumber,
			String remitterIFSCCode, String paymentMode, String senderToReceiverInformation, String transactionRemark,
			String rejectReason, String status) {
		super();
		this.clientCode = clientCode;
		this.virtualAccountNumber = virtualAccountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateAndTime = transactionDateAndTime;
		this.utrNo = utrNo;
		this.remitterName = remitterName;
		this.remitterAccountNumber = remitterAccountNumber;
		this.remitterIFSCCode = remitterIFSCCode;
		this.paymentMode = paymentMode;
		this.senderToReceiverInformation = senderToReceiverInformation;
		this.transactionRemark = transactionRemark;
		this.rejectReason = rejectReason;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ECollection [clientCode=" + clientCode + ", virtualAccountNumber=" + virtualAccountNumber
				+ ", transactionAmount=" + transactionAmount + ", transactionDateAndTime=" + transactionDateAndTime
				+ ", utrNo=" + utrNo + ", remitterName=" + remitterName + ", remitterAccountNumber="
				+ remitterAccountNumber + ", remitterIFSCCode=" + remitterIFSCCode + ", paymentMode=" + paymentMode
				+ ", senderToReceiverInformation=" + senderToReceiverInformation + ", transactionRemark="
				+ transactionRemark + ", rejectReason=" + rejectReason + ", status=" + status + "]";
	}
	
}
