package com.benardi.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.benardi.cursomc.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BoletoPayment extends Payment {
	
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date expirationDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;

	public BoletoPayment() {
		super();
	}

	public BoletoPayment(Integer id, PaymentState state, Purchase purchase, Date expirationDate, Date paymentDate) {
		super(id, state, purchase);

		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
