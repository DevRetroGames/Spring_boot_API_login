package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.InformacionDTO;

@Service
public interface IInformacionesService {

	public List<InformacionDTO> getAllInformations() ;
	
	public InformacionDTO getInformationById( UUID informacionId ) ;
	
	public List<InformacionDTO> getInformationByRole( UUID rolId ) ;
	
	public InformacionDTO createInformation( 
			InformacionDTO informacionDTO , UUID rolId ) ;
	
	public InformacionDTO updateInformation( 
			UUID informacionId , 
			InformacionDTO informacionDTO , 
			UUID rolId ) ;
	
	public void deleteInformation( UUID informacionId ) ;
	
}
