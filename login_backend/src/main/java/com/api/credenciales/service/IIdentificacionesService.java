package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.IdentificacionDTO;

@Service
public interface IIdentificacionesService {
	
	public List<IdentificacionDTO> getAllIdentifications() ;
	
	public IdentificacionDTO getIdentificationById( UUID identificacionId ) ;
	
	public List<IdentificacionDTO> getIdentificationByInformation( UUID informacionId ) ;
	
	public IdentificacionDTO createIdentification( 
			IdentificacionDTO identificacionDTO , UUID informacionId ) ;
	
	public IdentificacionDTO updateIdentification( 
			UUID identificacionId , 
			IdentificacionDTO identificacionDTO , 
			UUID informacionId ) ;
	
	public void deleteIdentification( UUID identificacionId ) ;

}
