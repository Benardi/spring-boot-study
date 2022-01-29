package com.benardi.cursomc.domain.enums;

public enum PaymentState {
	PENDING(1, "Pending"), PAID(2, "Paid"), CANCELLED(3, "Cancelled");

	private int code;
	private String description;

	private PaymentState(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static PaymentState toEnum(Integer code) {
		PaymentState result = null;

		if (code != null) {
			for (PaymentState state : PaymentState.values()) {
				if (code.equals(state.getCode())) {
					result = state;
				}
			}
		}

		if (result == null) {
			throw new IllegalArgumentException("Invalid id: " + code);
		}

		return result;
	}
}
