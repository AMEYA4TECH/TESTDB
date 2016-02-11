package com;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

	@JsonProperty("Message")
	private String message;

	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
