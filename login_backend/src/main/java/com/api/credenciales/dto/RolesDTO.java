package com.api.credenciales.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RolesDTO {
	
	
	private UUID rolesId ;
	
	@NotBlank( message = "Name is required." )
	private String name ;
	
	private boolean status ;
	
}
