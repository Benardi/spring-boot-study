package com.benardi.cursomc.domain.enums;

public enum TypeClient {
	NATURALPERSON(1, "Natural Person"), LEGALPERSON(2, "Legal Person");

	private int code;
	private String description;

	private TypeClient(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static TypeClient toEnum(Integer code) {
		TypeClient result = null;

		if (code != null) {
			for (TypeClient v : TypeClient.values()) {
				if (code.equals(v.getCode())) {
					result = v;
				}
			}
		}

		if (result == null) {
			throw new IllegalArgumentException("Invalid id: " + code);
		}

		return result;
	}
}
