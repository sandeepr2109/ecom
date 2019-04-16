package com.Ecommerce.entity;

import org.springframework.context.annotation.Bean;


public class OderJpaRecordbean {

	private static final long serialVersionUID = 1L;
	 private Integer    orderId      ; 
	 private String     emailId      ;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
