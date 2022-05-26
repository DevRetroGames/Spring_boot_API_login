package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.InformacionDTO;

@Service
public interface IInformacionesService {

	/**
	 * 
	 * Lista con todos los registros de la tabla informaciones
	 * 
	 * @return List<InformacionDTO>
	 */
	public List<InformacionDTO> getAllInformations() ;
	
	
	/**
	 * 
	 * Obtiene un registro de la tabla informaciones basado en un id.
	 * 
	 * @param informacionID
	 * @return InformacionDTO
	 */
	public InformacionDTO getInformationById( UUID informacionID ) ;
	
	
	/**
	 * 
	 * Crea un nuevo registro en la tabla informaciones.
	 * 
	 * @param informacionDTO
	 * @param rolID
	 * @return InformacionDTO
	 */
	public InformacionDTO createInformation( InformacionDTO informacionDTO , UUID rolID ) ;
	
	
	/**
	 * 
	 * Actualiza un registro de la tabla informaciones.
	 * 
	 * @param informacionID
	 * @param informacionDTO
	 * @param rolID
	 * @return InformacionDTO
	 */
	public InformacionDTO updateInformation( UUID informacionID , InformacionDTO informacionDTO , UUID rolID ) ;
	
	
	/**
	 * 
	 * Elimina un registro de la tabla informaciones basado en un id.
	 * 
	 * @param informacionID
	 */
	public void deleteInformation( UUID informacionID ) ;
	
}
