package com.api.credenciales.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RolesDTO {
	
	private UUID rolesId ;
	
	@NotBlank( message = "Nombre obligatorio" )
	private String nombre ;
	
	private Integer nivel ;
	
	private boolean estado ;
	
}
