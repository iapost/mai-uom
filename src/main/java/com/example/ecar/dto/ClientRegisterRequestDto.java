package com.example.ecar.dto;

import javax.validation.constraints.*;

public class ClientRegisterRequestDto {
	
	@NotNull(message="Το ΑΦΜ είναι υποχρεωτικό")
	@Min(value=100000000, message="Ο ΑΦΜ πρέπει να είναι 9ψήφιος")
	@Max(value=999999999, message="Ο ΑΦΜ πρέπει να είναι 9ψήφιος")
	public int afm;
	@NotBlank(message="Το password είναι υποχρεωτικό")
	public String password;
	@NotBlank(message="Το όνομα είναι υποχρεωτικό")
	public String firstName;
	@NotBlank(message="Το επώνυμο είναι υποχρεωτικό")
	public String lastName;
	@NotBlank(message="Το email είναι υποχρεωτικό")
	@Email(message="Η μορφή του email δεν είναι σωστή")
	public String email;
}
