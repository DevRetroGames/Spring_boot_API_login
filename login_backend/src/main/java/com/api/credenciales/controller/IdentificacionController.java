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
@RequestMapping( "/identificacion" )
public class IdentificacionController {
	
	@Autowired
	@Qualifier("identificacion")
	private IIdentificacionesService service ;

	@GetMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public List<IdentificacionDTO> getAllIdentifications() {		
		return this.service.getAllIdentifications() ;
	}
	
	@GetMapping( "/find/identificacion/" )
	@ResponseStatus( HttpStatus.OK )
	public IdentificacionDTO getSingleIdentification( 
			@RequestParam UUID indentificacionId ) {
		return this.service.getIdentificationById( indentificacionId ) ;
	}
	
	@GetMapping( "/informacion/identificacion" )
	@ResponseStatus( HttpStatus.OK )
	public List<IdentificacionDTO> getIdentificationByInformation( 
			@RequestParam UUID informacionId ) {
		return this.service.getIdentificationByInformation( informacionId ) ;
	}
	
	@PostMapping( "/" )
	@ResponseStatus( HttpStatus.CREATED )
	public IdentificacionDTO createIdentification( 
			@Valid @RequestBody IdentificacionDTO identificacionDTO , 
			@RequestParam UUID informacionId ) {		
		return service.createIdentification( identificacionDTO , informacionId ) ;
	}
	
	@PutMapping( "/")
	@ResponseStatus( HttpStatus.OK )
	public IdentificacionDTO updateIdentification( 
			@RequestParam UUID indentificacionId , 
			@Valid @RequestBody IdentificacionDTO identificacionDTO , 
			@RequestParam UUID informacionId ) {		
		return this.service.updateIdentification( 
				indentificacionId , identificacionDTO , informacionId ) ;		
	}
	
	@DeleteMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public ApiResponse deleteIdentification( @RequestParam UUID indentificacionId ) {		
		this.service.deleteIdentification( indentificacionId ) ;
		return new ApiResponse( "Information Deleted Successfully." , true ) ;
	}
	
}
