package com.api.credenciales.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.exceptions.NotFoundException;
import com.api.credenciales.helper.FindByIdHelper;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IRolesRepository;
import com.api.credenciales.service.IRolesService;
import com.api.credenciales.util.MapperUtil;

@Service
@Transactional
@Qualifier("roles")
public class RolesServiceImpl implements IRolesService {
	
	@Autowired
	private IRolesRepository iRolesRepository ;
	
	@Autowired
	private FindByIdHelper findByIdHelper ;
	
	@Autowired
	private MapperUtil mapperUtil ;

	@Override	
	public List<RolesDTO> getAllRoles() {
		
		return this.iRolesRepository.findAll()
				.stream()
				.map( mapperUtil::roleEntityToRoleDTO )
				.collect( Collectors.toList() ) ;
		
	}
	
	@Override
	public RolesDTO getRole( UUID roleID ) {	
		
		Roles rol = this.iRolesRepository.findById( roleID )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , roleID ) ) ;
		
		return mapperUtil.roleEntityToRoleDTO( rol ) ;		
	}
	
	/*
	@Override
	public List<roleIdentificacionDTO> getRoleIdentificaciones( UUID roleID ) {
		return null ;		
	}*/
	
	@Override
	public RolesDTO createRole( RolesDTO rolesDTO ) {						
		return mapperUtil.roleEntityToRoleDTO(
			this.iRolesRepository.save( mapperUtil.roleDTOToRoleEntity( rolesDTO ) ) 
		) ;		
	}
	
	@Override
	public RolesDTO updateRole( UUID roleID , RolesDTO rolesDTO ) {
		
		Roles rol = findByIdHelper.getRoleById( roleID ) ;

		rol.setName( rolesDTO.getName() ) ;
		rol.setStatus( rolesDTO.isStatus() ) ;
		
		return mapperUtil.roleEntityToRoleDTO( this.iRolesRepository.save( rol ) ) ;

	} // end updateRole

	@Override
	public void deleteRole( UUID roleID ) {
		this.iRolesRepository.delete( findByIdHelper.getRoleById( roleID ) ) ;		
	} // end deleteRole

}





















