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
import com.api.credenciales.repository.IInformacionRepository;
import com.api.credenciales.service.IInformacionesService;
import com.api.credenciales.util.MapperUtil;

@Service
@Transactional
@Qualifier("informaciones")
public class InformacionesServiceImpl implements IInformacionesService {
	
	@Autowired
	private IInformacionRepository iInformacionRepository ;
	
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
	public InformacionDTO getInformation( UUID informacionId ) {
		
		Informacion info = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;
				
		return mapperUtil.informacionEntityToInformacionDTO( info ) ;
		
	}

	
	
	@Override
	public InformacionDTO createInformation( InformacionDTO informacionDTO ) {
		
		return mapperUtil.informacionEntityToInformacionDTO( 
				this.iInformacionRepository.save( 
						this.mapperUtil.informacionDTOToInformacionEntity( informacionDTO ) 
					) 
			) ;
		
	}

	
	
	@Override
	public InformacionDTO updateInformation( UUID informacionId , InformacionDTO informacionDTO ) {
		
		Informacion informacion = this.iInformacionRepository.findById( informacionId )
				.orElseThrow( () -> new NotFoundException( 
						"Informacion" , "id" , informacionId ) 
					) ;

		informacion.setNames( informacionDTO.getNames() ) ;
		informacion.setLastNames( informacionDTO.getLastNames() ) ;
		informacion.setYears( informacionDTO.getYears() ) ;
		informacion.setCellPhonoNumber( informacionDTO.getCellPhonoNumber() ) ;
		informacion.setEmail( informacionDTO.getEmail() ) ;
		informacion.setDni( informacionDTO.getDni() ) ;
		informacion.setCountry( informacionDTO.getCountry() ) ;
		informacion.setCity( informacionDTO.getCity() ) ;
		
		return mapperUtil.informacionEntityToInformacionDTO( 
				this.iInformacionRepository.save( informacion ) 
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
