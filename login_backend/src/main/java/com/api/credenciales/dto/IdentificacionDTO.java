package com.api.credenciales.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class IdentificacionDTO {
	
	private UUID identificacionesId ;
	
	private InformacionDTO informacion ;
	
	private RolesDTO rol ;
	
	@NotBlank( message = "Usuario requerido." )
	private String usuario ;
	
	@NotBlank( message = "Contraseña requerida." )
	private String passWord ;
	
	@NotNull( message = "Status requerido." )
	private boolean status ;

}
