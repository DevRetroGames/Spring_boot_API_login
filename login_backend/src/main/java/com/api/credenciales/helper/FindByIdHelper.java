package com.api.credenciales.helper;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.credenciales.exceptions.NotFoundException;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IRolesRepository;

@Component
public class FindByIdHelper {
	
	@Autowired
	private IRolesRepository iRolesRepository ;
	
	public Roles getRoleById( UUID roleId ) {
		
		return this.iRolesRepository.findById( roleId )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , roleId ) ) ;
		
	}

}
