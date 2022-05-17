package com.api.credenciales.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class IdentificacionDTO {
	
	private UUID idenId ;
	
	private InformacionDTO informacion ;
	
	private String usuario ;
	
	private String passWord ;

}
