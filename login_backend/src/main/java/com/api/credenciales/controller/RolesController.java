package com.api.credenciales.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.credenciales.dto.ApiResponse;
import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.service.IRolesService;

@RestController
@CrossOrigin( origins = "http://localhost:8081" )
@RequestMapping( "/api/roles" )
public class RolesController {
	
	@Autowired
	@Qualifier("roles")
	private IRolesService service ;
	
	@GetMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public List<RolesDTO> getAllRoles() {		
		return this.service.getAllRoles() ;
	}
	
	@GetMapping( "/role" )
	@ResponseStatus( HttpStatus.OK )
	public RolesDTO getSingleRole( @RequestParam UUID roleID ) {
		return this.service.getRole( roleID ) ;
	}
	
	@PostMapping( "/" )
	@ResponseStatus( HttpStatus.CREATED )
	public RolesDTO createRole( @Valid @RequestBody RolesDTO rolesDTO ) {		
		return service.createRole( rolesDTO ) ;
	}
	
	@PutMapping( "/")
	@ResponseStatus( HttpStatus.OK )
	public RolesDTO updateRole( @RequestParam UUID roleID , @Valid @RequestBody RolesDTO rolesDTO ) {		
		return this.service.updateRole( roleID , rolesDTO ) ;		
	}
	
	@DeleteMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public ApiResponse deleteRole( @RequestParam UUID roleID ) {		
		this.service.deleteRole( roleID ) ;
		return new ApiResponse( "Role Deleted Successfully." , true ) ;
	}
	
}















