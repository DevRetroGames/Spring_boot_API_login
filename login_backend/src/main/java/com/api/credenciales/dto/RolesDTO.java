package com.api.credenciales.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RolesDTO {
	
	
	private UUID rolesId ;
	
	@NotBlank( message = "Name is required." )
	private String name ;
	
	@NotEmpty( message = "Status may not be empty." )
	private boolean status ;
	
}
