package com.benardi.cursomc.domain;

import javax.persistence.Entity;

import com.benardi.cursomc.domain.enums.PaymentState;

@Entity
public class CreditCardPayment extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	private Integer installmentsNumber;

	public CreditCardPayment() {
		super();
	}

	public CreditCardPayment(Integer id, PaymentState state, Purchase purchase, Integer installmentsNumber) {
		super(id, state, purchase);

		this.installmentsNumber = installmentsNumber;

	}

	public Integer getInstallmentsNumber() {
		return installmentsNumber;
	}

	public void setInstallmentsNumber(Integer installmentsNumber) {
		this.installmentsNumber = installmentsNumber;
	}

}
