package com.api.credenciales.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class InformacionDTO {

	private UUID infoId ;
	
	private String nombres ;
	
	private String apellidos ;
	
	private int edad ;
	
	private String fono ;
	
	private String email ;
	
	private RolesDTO rol ;
	
}
