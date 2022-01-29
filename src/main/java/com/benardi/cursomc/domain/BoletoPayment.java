package com.benardi.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.benardi.cursomc.domain.enums.PaymentState;

@Entity
public class BoletoPayment extends Payment {
	
	private static final long serialVersionUID = 1L;

	private Date expirationDate;
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
