package com.api.credenciales.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.credenciales.dto.RolesDTO;

@Service
public interface IRolesService {
	
	public List<RolesDTO> getAllRoles() ;
	
	public RolesDTO getRoleById( UUID roleId ) ;
	
	public RolesDTO createRole( RolesDTO rolesDTO ) ;
	
	public RolesDTO updateRole( UUID roleId , RolesDTO rolesDTO ) ;
	
	public void deleteRole( UUID roleId ) ;
	
}
