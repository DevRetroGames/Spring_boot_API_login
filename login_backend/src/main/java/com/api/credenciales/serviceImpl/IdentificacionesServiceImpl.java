package com.api.credenciales.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.credenciales.dto.IdentificacionDTO;
import com.api.credenciales.exceptions.NotFoundException;
import com.api.credenciales.model.Identifications;
import com.api.credenciales.model.Informacion;
import com.api.credenciales.repository.IIdentificacionRepository;
import com.api.credenciales.repository.IInformacionRepository;
import com.api.credenciales.service.IIdentificacionesService;
import com.api.credenciales.util.MapperUtil;

@Service
@Transactional
@Qualifier("identificacion")
public class IdentificacionesServiceImpl implements IIdentificacionesService {
	
	@Autowired
	private IIdentificacionRepository iIdentificacionRepository ;
	
	@Autowired
	private IInformacionRepository iInformacionRepository ;
	
	@Autowired
	private MapperUtil mapperUtil ;

	@Override
	public List<IdentificacionDTO> getAllIdentifications() {
		
		return this.iIdentificacionRepository.findAll()
				.stream()
				.map( mapperUtil::identificacionEntityToIdentificacionDTO )
				.collect( Collectors.toList() ) ;
		
	}

	@Override
	public IdentificacionDTO getIdentificationById( UUID indentificacionId ) {

		Identifications identificacion = this.iIdentificacionRepository
				.findById( indentificacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionId ) 
					) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO( identificacion ) ;
		
	}
	
	@Override
	public List<IdentificacionDTO> getIdentificationByInformation( UUID informacionId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
		
		return this.iIdentificacionRepository.findByInformacion( info )
				.stream()
				.map( mapperUtil::identificacionEntityToIdentificacionDTO )
				.collect( Collectors.toList() ) ;
	}

	@Override
	public IdentificacionDTO createIdentification( 
			IdentificacionDTO identificacionDTO , UUID informacionId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
		
		Identifications iden = mapperUtil
				.identificacionDTOToIdentificacionEntity( identificacionDTO ) ;

		iden.setInformacion( info ) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO(
				this.iIdentificacionRepository.save( iden ) 
			) ;
		
	}

	@Override
	public IdentificacionDTO updateIdentification( 
			UUID indentificacionId , 
			IdentificacionDTO identificacionDTO , 
			UUID informacionId ) {
		
		Identifications iden = this.iIdentificacionRepository
				.findById( indentificacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionId ) 
					) ;
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;

		iden.setUsuario( identificacionDTO.getUsuario() ) ;
		iden.setPassWord( identificacionDTO.getPassWord() ) ;
		iden.setInformacion( info ) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO( 
				this.iIdentificacionRepository.save( iden ) 
			) ;
		
	}

	@Override
	public void deleteIdentification( UUID indentificacionId ) {
		
		Identifications identificacion = this.iIdentificacionRepository
				.findById( indentificacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionId ) 
					) ;
		
		this.iIdentificacionRepository.delete( identificacion ) ;
		
	}

}
