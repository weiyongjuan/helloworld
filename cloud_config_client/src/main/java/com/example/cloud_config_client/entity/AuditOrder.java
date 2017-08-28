package com.example.cloud_config_client.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="audit_order")
public class AuditOrder {
	@Id
	private String id ;
	private String caseId;
	private String orderId;
	private String orderNo;
	private Patient patient;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "AuditOrder [id=" + id + ", caseId=" + caseId + ", orderId=" + orderId + ", orderNo=" + orderNo
				+ ", patient=" + patient + "]";
	}
	
	

}
