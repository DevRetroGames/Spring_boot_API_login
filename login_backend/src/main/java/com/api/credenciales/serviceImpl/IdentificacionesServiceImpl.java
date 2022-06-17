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
import com.api.credenciales.model.Identificacion;
import com.api.credenciales.model.Informacion;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IIdentificacionRepository;
import com.api.credenciales.repository.IInformacionRepository;
import com.api.credenciales.repository.IRolesRepository;
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
	private IRolesRepository iRolesRepository ;
	
	@Autowired
	private InformacionesServiceImpl informacionesServiceImpl ;
	
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
	public IdentificacionDTO getIdentification( UUID indentificacionID ) {

		Identificacion identificacion = this.iIdentificacionRepository
				.findById( indentificacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionID ) 
					) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO( identificacion ) ;
		
	}
	
	
	
	@Override
	public IdentificacionDTO getIdentificacionRole( UUID identificacionID ) {
		
		Identificacion identificacion = this.iIdentificacionRepository.findById( identificacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , identificacionID ) 
					) ;
		
		IdentificacionDTO identificacionDTO = this.mapperUtil.identificacionEntityToIdentificacionDTO( identificacion ) ;
		
		identificacionDTO.setInformacion( null ) ;
		
		
		return identificacionDTO ;
		
	}
	
	
	
	@Override
	public IdentificacionDTO getIdentificacionInformacion( UUID identificacionID ) {
		
		Identificacion identificacion = this.iIdentificacionRepository.findById( identificacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , identificacionID ) 
					) ;
		
		IdentificacionDTO identificacionDTO = this.mapperUtil.identificacionEntityToIdentificacionDTO( identificacion ) ;
		
		identificacionDTO.setRol( null ) ;
		
		
		return identificacionDTO ;
		
	}

	
	
	@Override
	public IdentificacionDTO createIdentification( 
			IdentificacionDTO identificacionDTO , UUID informacionID , UUID rolID ) {
		
		Informacion informacion = this.iInformacionRepository
				.findById( informacionID )
				.orElseThrow( () -> new NotFoundException( "Informacion" , "id" , informacionID ) 
			) ;
		
		Roles rol = this.iRolesRepository
				.findById( rolID )
				.orElseThrow( () -> new NotFoundException( "Role" , "id" , rolID ) 
			) ;
		
		
		Identificacion identificacion = this.mapperUtil
				.identificacionDTOToIdentificacionEntity( identificacionDTO ) ;
		
		identificacion.setInformacion( informacion ) ;
		identificacion.setRol( rol ) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO( 
				this.iIdentificacionRepository.save( identificacion ) ) ;
		
	}

	
	
	@Override
	public IdentificacionDTO updateIdentification( 
			UUID indentificacionID , IdentificacionDTO identificacionDTO , 
			UUID informacionID , UUID rolID ) {
		
		Identificacion identificacion = this.iIdentificacionRepository
				.findById( indentificacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionID ) ) ;
		
		Informacion informacion = this.iInformacionRepository
				.findById( informacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionID ) 
					) ;
		
		Roles rol = this.iRolesRepository
				.findById( rolID )
				.orElseThrow( () -> new NotFoundException( 
						"Role" , "id" , rolID ) 
					) ;

		identificacion.setInformacion( informacion ) ;
		identificacion.setRol( rol ) ;
		identificacion.setUsuario( identificacionDTO.getUsuario() ) ;
		identificacion.setPassWord( identificacionDTO.getPassWord() ) ;
		identificacion.setStatus( identificacionDTO.isStatus() ) ;
		
		return mapperUtil.identificacionEntityToIdentificacionDTO( 
				this.iIdentificacionRepository.save( identificacion ) ) ;
		
	}

	
	
	@Override
	public void deleteIdentification( UUID indentificacionID ) {
		
		Identificacion identificacion = this.iIdentificacionRepository
				.findById( indentificacionID )
				.orElseThrow( () -> new NotFoundException( 
						"Identificacion" , "id" , indentificacionID ) 
					) ;
		/*
		this.informacionesServiceImpl.deleteInformation( 
				identificacion.getInformacion().getInformacionesId() ) ;*/
		
		this.iIdentificacionRepository.delete( identificacion ) ;
		
	}


}
