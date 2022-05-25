package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.RolesDTO;

@Service
public interface IRolesService {
	
	/**
	 * 
	 * Lista con todos los registros de la tabla roles, 
	 * sin la relación con la tabla identificaciones.
	 * 
	 * @return List<RolesDTO>
	 */
	public List<RolesDTO> getAllRoles() ;
	
	
	/**
	 * 
	 * Obtiene un registro de la tabla roles basado en un id.
	 * 
	 * @param roleId
	 * 
	 * @return RolesDTO
	 */
	public RolesDTO getRole( UUID roleId ) ;
	
	
	/**
	 * 
	 * Obtiene una lista con todos los registros en la tabla informaciones
	 * que tengan una relación con el id de la tabla roles.
	 * 
	 * @param roleID
	 * 
	 * @return List<rolesIdentificacionDTO>
	 */
	//public List<roleIdentificacionDTO> getRoleIdentificaciones( UUID roleID ) ;
	
	
	/**
	 * 
	 * Crea un nuevo registro en la tabla roles.
	 * 
	 * @param rolesDTO
	 * 
	 * @return RolesDTO
	 */
	public RolesDTO createRole( RolesDTO rolesDTO ) ;
	
	
	/**
	 * 
	 * Actualiza un registro de la tabla roles.
	 * 
	 * @param roleId
	 * @param rolesDTO
	 * 
	 * @return RolesDTO
	 */
	public RolesDTO updateRole( UUID roleId , RolesDTO rolesDTO ) ;
	
	
	/**
	 * 
	 * Elimina un registro de la tabla roles basado en un id.
	 * 
	 * @param roleId
	 */
	public void deleteRole( UUID roleId ) ;
	
}
