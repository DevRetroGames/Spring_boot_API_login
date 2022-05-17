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
import com.api.credenciales.dto.InformacionDTO;
import com.api.credenciales.service.IInformacionesService;

@RestController
@CrossOrigin( origins = "http://localhost:8081" )
@RequestMapping( "/informacion" )
public class InformacionController {
	
	@Autowired
	@Qualifier("info")
	private IInformacionesService service ;

	@GetMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public List<InformacionDTO> getAllInformations() {		
		return this.service.getAllInformations() ;
	}
	
	@GetMapping( "/find/informacion/" )
	@ResponseStatus( HttpStatus.OK )
	public InformacionDTO getSingleInformation( @RequestParam UUID informacionId ) {
		return this.service.getInformationById( informacionId ) ;
	}
	
	@GetMapping( "/role/informacion" )
	@ResponseStatus( HttpStatus.OK )
	public List<InformacionDTO> getInformationByRole( @RequestParam UUID rolId ) {
		return this.service.getInformationByRole( rolId ) ;
	}
	
	@PostMapping( "/" )
	@ResponseStatus( HttpStatus.CREATED )
	public InformacionDTO createInformation( 
			@Valid @RequestBody InformacionDTO informacionDTO , 
			@RequestParam UUID rolId ) {		
		return service.createInformation( informacionDTO , rolId ) ;
	}
	
	@PutMapping( "/")
	@ResponseStatus( HttpStatus.OK )
	public InformacionDTO updateInformation( 
			@RequestParam UUID informacionId , 
			@Valid @RequestBody InformacionDTO informacionDTO , 
			@RequestParam UUID rolId ) {		
		return this.service.updateInformation( informacionId , informacionDTO , rolId ) ;		
	}
	
	@DeleteMapping( "/" )
	@ResponseStatus( HttpStatus.OK )
	public ApiResponse deleteInformation( @RequestParam UUID informacionId ) {		
		this.service.deleteInformation(informacionId) ;
		return new ApiResponse( "Information Deleted Successfully." , true ) ;
	}
	
}




















