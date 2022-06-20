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
import com.api.credenciales.dto.IdentificacionDTO;
import com.api.credenciales.service.IIdentificacionesService;

@RestController
@CrossOrigin( origins = "http://localhost:8081" )
@RequestMapping( "/api/identificacion" )
public class IdentificacionController {
	
	
	@Autowired
	@Qualifier("identificacion")
	private IIdentificacionesService service ;

	
	
	@GetMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public List<IdentificacionDTO> getAllIdentifications() {		
		return this.service.getAllIdentifications() ;
	}
	
	
	
	@GetMapping( "/identificacion" )
	@ResponseStatus( HttpStatus.OK )
	public IdentificacionDTO getSingleIdentification( @RequestParam UUID indentificacionID ) {
		return this.service.getIdentification( indentificacionID ) ;
	}
	
	
	
	@PostMapping( "/" )
	@ResponseStatus( HttpStatus.CREATED )
	public IdentificacionDTO createIdentification( 
			@Valid @RequestBody IdentificacionDTO identificacionDTO , 
			@RequestParam UUID informacionID , 
			@RequestParam UUID rolID ) {		
		return service.createIdentification( identificacionDTO , informacionID , rolID ) ;
	}
	
	
	
	@PutMapping( "/")
	@ResponseStatus( HttpStatus.OK )
	public IdentificacionDTO updateIdentification( 
			@RequestParam UUID indentificacionID , 
			@Valid @RequestBody IdentificacionDTO identificacionDTO , 
			@RequestParam UUID informacionID , 
			@RequestParam UUID rolID ) {		
		return this.service.updateIdentification( 
				indentificacionID , identificacionDTO , informacionID , rolID ) ;		
	}
	
	
	
	@DeleteMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public ApiResponse deleteIdentification( @RequestParam UUID indentificacionID ) {		
		this.service.deleteIdentification( indentificacionID ) ;
		return new ApiResponse( "Information Deleted Successfully." , true ) ;
	}
	
}
