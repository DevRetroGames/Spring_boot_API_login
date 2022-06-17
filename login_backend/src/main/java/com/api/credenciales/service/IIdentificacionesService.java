package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.IdentificacionDTO;

@Service
public interface IIdentificacionesService {
	
	
	/**
	 * 
	 * Lista con todos los registros de la tabla informaciones.
	 * 
	 * @return
	 */
	public List<IdentificacionDTO> getAllIdentifications() ;
	
	
	
	/**
	 * 
	 * Devuelve un registro de la tabla identificaciones.
	 * 
	 * @param identificacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO getIdentification( UUID identificacionID ) ;
	
	
	
	/**
	 * 
	 * Devuelve un registro sin los datos de la tabla informaciones.
	 * 
	 * @param identificacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO getIdentificacionRole( UUID identificacionID ) ;
	
	
	
	/**
	 * 
	 * Devuelve un registro sin los datos de la tabla roles.
	 * 
	 * @param identificacionID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO getIdentificacionInformacion( UUID identificacionID ) ;
	
	
	
	/**
	 * 
	 * Crea un nuevo registro en tabla identificaciones, 
	 * con la relacion con las tablas roles e informaciones.
	 * 
	 * @param identificacionDTO
	 * @param informacionID
	 * @param rolID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO createIdentification( IdentificacionDTO identificacionDTO , UUID informacionID , UUID rolID ) ;
	
	
	
	/**
	 * 
	 * Actualiza un registro de la tabla identificaciones.
	 * 
	 * @param identificacionID
	 * @param identificacionDTO
	 * @param informacionID
	 * @param rolID
	 * @return IdentificacionDTO
	 */
	public IdentificacionDTO updateIdentification( 
			UUID identificacionID , IdentificacionDTO identificacionDTO , UUID informacionID , UUID rolID ) ;
	
	
	
	/**
	 * 
	 * Elimina un registro de la tabla identificaciones basado en un id.
	 * 
	 * @param identificacionID
	 */
	public void deleteIdentification( UUID identificacionID ) ;

}
