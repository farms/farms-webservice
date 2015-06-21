package br.com.model;

public class ErrorResponse {
	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String code;
	public String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
