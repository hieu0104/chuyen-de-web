package com.ecommerce.shoes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDTO {

	@NotNull
	@Size(min = 6, max = 20)
	private String username;

	@NotNull
	@Size(min = 8, max = 20)
	private String password;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	@Email
	private String email;



}
