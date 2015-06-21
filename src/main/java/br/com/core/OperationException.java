package br.com.core;

public class OperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3978056373016621584L;
	private String code;
	private String message;
	
	public OperationException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
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
