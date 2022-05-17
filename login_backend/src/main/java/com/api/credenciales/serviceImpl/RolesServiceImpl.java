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
	public RolesDTO getRoleById( UUID roleId ) {	
		
		Roles rol = this.iRolesRepository.findById( roleId )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , roleId ) ) ;
		
		return mapperUtil.roleEntityToRoleDTO( rol ) ;		
	}
	
	@Override
	public RolesDTO createRole( RolesDTO rolesDTO ) {						
		return mapperUtil.roleEntityToRoleDTO(
			this.iRolesRepository.save( mapperUtil.roleDTOToRoleEntity( rolesDTO ) ) 
		) ;		
	}
	
	@Override
	public RolesDTO updateRole( UUID roleId , RolesDTO rolesDTO ) {
		
		Roles rol = findByIdHelper.getRoleById( roleId ) ;

		rol.setNombre( rolesDTO.getNombre() ) ;
		rol.setNivel( rolesDTO.getNivel() ) ;
		rol.setEstado( rolesDTO.isEstado() ) ;
		
		return mapperUtil.roleEntityToRoleDTO( this.iRolesRepository.save( rol ) ) ;

	} // end updateRole

	@Override
	public void deleteRole( UUID roleId ) {
		this.iRolesRepository.delete( findByIdHelper.getRoleById( roleId ) ) ;		
	} // end deleteRole

}





















