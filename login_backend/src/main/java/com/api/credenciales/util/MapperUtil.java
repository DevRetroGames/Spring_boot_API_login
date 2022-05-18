package com.api.credenciales.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.credenciales.dto.IdentificacionDTO;
import com.api.credenciales.dto.InformacionDTO;
import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.model.Identificacion;
import com.api.credenciales.model.Informacion;
import com.api.credenciales.model.Roles;

@Component
public class MapperUtil {

	@Autowired
	private ModelMapper modelMapper ;
	
	// roles
	
	public RolesDTO roleEntityToRoleDTO( Roles roles ) {
		return modelMapper.map( roles , RolesDTO.class ) ;
	}
	
	public Roles roleDTOToRoleEntity( RolesDTO rolesDTO ) {
		return modelMapper.map( rolesDTO , Roles.class ) ;
	}
	
	// Information
	
	public InformacionDTO informacionEntityToInformacionDTO( Informacion informacion ) {
		return modelMapper.map( informacion , InformacionDTO.class ) ;
	}
	
	public Informacion informacionDTOToInformacionEntity( InformacionDTO informacionDTO ) {
		return modelMapper.map( informacionDTO , Informacion.class ) ;
	}
	
	// Identification
	
	public IdentificacionDTO identificacionEntityToIdentificacionDTO( Identificacion identificacion ) {
		return modelMapper.map( identificacion , IdentificacionDTO.class ) ;
	}
	
	public Identificacion identificacionDTOToIdentificacionEntity( IdentificacionDTO identificacionDTO ) {
		return modelMapper.map( identificacionDTO , Identificacion.class ) ;
	}
	
}
































