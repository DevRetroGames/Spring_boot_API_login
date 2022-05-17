package com.api.credenciales.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.credenciales.dto.InformacionDTO;
import com.api.credenciales.exceptions.NotFoundException;
import com.api.credenciales.model.Informacion;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IInformacionRepository;
import com.api.credenciales.repository.IRolesRepository;
import com.api.credenciales.service.IInformacionesService;
import com.api.credenciales.util.MapperUtil;

@Service
@Transactional
@Qualifier("info")
public class InformacionesServiceImpl implements IInformacionesService {
	
	@Autowired
	private IInformacionRepository iInformacionRepository ;
	
	@Autowired
	private IRolesRepository iRolesRepository ;
	
	@Autowired
	private MapperUtil mapperUtil ;

	@Override
	public List<InformacionDTO> getAllInformations() {
		
		return this.iInformacionRepository.findAll()
				.stream()
				.map( mapperUtil::informacionEntityToInformacionDTO )
				.collect( Collectors.toList() ) ;
		
	}

	@Override
	public InformacionDTO getInformationById( UUID informacionId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
				
		return mapperUtil.informacionEntityToInformacionDTO( info ) ;
		
	}
	
	@Override
	public List<InformacionDTO> getInformationByRole( UUID rolId ) {
		
		Roles rol = this.iRolesRepository.findById( rolId )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , rolId ) ) ;
		
		return this.iInformacionRepository.findByRol( rol )
				.stream()
				.map( mapperUtil::informacionEntityToInformacionDTO )
				.collect( Collectors.toList() ) ;
		
	}

	@Override
	public InformacionDTO createInformation( 
			InformacionDTO informacionDTO , UUID rolId ) {
		
		Roles rol = this.iRolesRepository.findById( rolId )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , rolId ) ) ;
		
		Informacion info = mapperUtil.informacionDTOToInformacionEntity( informacionDTO ) ;
		
		info.setRol( rol ) ;
		
		return mapperUtil.informacionEntityToInformacionDTO( 
				this.iInformacionRepository.save( info ) 
			) ;
		
	}

	@Override
	public InformacionDTO updateInformation( 
			UUID informacionId , InformacionDTO informacionDTO , UUID rolId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
		
		Roles rol = this.iRolesRepository.findById( rolId )
				.orElseThrow( () -> new NotFoundException( "Rol" , "id" , rolId ) ) ;

		info.setNombres( informacionDTO.getNombres() ) ;
		info.setApellidos( informacionDTO.getApellidos() ) ;
		info.setEdad( informacionDTO.getEdad() ) ;
		info.setFono( informacionDTO.getFono() ) ;
		info.setEmail( informacionDTO.getEmail() ) ;
		info.setRol( rol ) ;
		
		return mapperUtil.informacionEntityToInformacionDTO( 
				this.iInformacionRepository.save( info ) 
			) ;
		
	}

	@Override
	public void deleteInformation( UUID informacionId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
		
		this.iInformacionRepository.delete( info ) ;
		
	}

}
