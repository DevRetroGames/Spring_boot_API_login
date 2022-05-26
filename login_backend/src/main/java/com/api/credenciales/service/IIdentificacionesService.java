package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.IdentificacionDTO;

@Service
public interface IIdentificacionesService {
	
	/**
	 * 
	 * Lista con todos los registros de la tabla informaciones
	 * 
	 * @return
	 */
	public List<IdentificacionDTO> getAllIdentifications() ;
	
	
	/**
	 * 
	 * 
	 * 
	 * @param identificacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO getIdentificationById( UUID identificacionID ) ;
	
	
	/**
	 * 
	 * 
	 * 
	 * @param identificacionDTO
	 * @param informacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO createIdentification( IdentificacionDTO identificacionDTO , UUID informacionID ) ;
	
	
	/**
	 * 
	 * 
	 * 
	 * @param identificacionID
	 * @param identificacionDTO
	 * @param informacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO updateIdentification( UUID identificacionID , IdentificacionDTO identificacionDTO , UUID informacionID ) ;
	
	
	/**
	 * 
	 * Elimina un registro de la tabla identificaciones basado en un id.
	 * 
	 * @param identificacionID
	 */
	public void deleteIdentification( UUID identificacionID ) ;

}
