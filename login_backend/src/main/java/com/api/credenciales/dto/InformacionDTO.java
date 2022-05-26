package com.api.credenciales.dto;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class InformacionDTO {

	private UUID informacionesId ;
	
	@NotBlank( message = "Nombres requeridos." )
	private String names ;
	
	@NotBlank( message = "Apellidos requeridos." )
	private String lastNames ;
	
	@NotNull( message = "Edad requerida." )
	@Min( value = 18 , message = "Se requiere una persona de mayor edad." )
	@Max( value = 60 , message = "Se requiere una persona más joven." )
	private int years ;
	
	@NotBlank( message = "Numero telefonico requerido." )
	private String cellPhonoNumber ;
	
	@NotBlank( message = "Email requerido." )
	@Email( 
		regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$" , // RFC 5322 
		message = "Email no valido." 
	)
	private String email ;
	
	@NotBlank( message = "DNI ó RUT requerido." )
	private String dni ;
	
	@NotBlank( message = "País requerido." )
	private String country ;
	
	@NotBlank( message = "Ciudad requerido." )
	private String city ;
	
}
