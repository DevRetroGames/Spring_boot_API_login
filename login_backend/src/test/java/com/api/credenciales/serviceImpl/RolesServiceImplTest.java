package com.api.credenciales.serviceImpl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.helper.FindByIdHelper;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IRolesRepository;
import com.api.credenciales.util.MapperUtil;

import lombok.extern.log4j.Log4j2;

@ExtendWith(MockitoExtension.class)
@Log4j2
public class RolesServiceImplTest {
	
	@Mock
	private FindByIdHelper findByIdHelper;

	@Mock
	private IRolesRepository iRolesRepository;

	@Mock
	private MapperUtil mapperUtil;
	
	@InjectMocks
	private RolesServiceImpl rolesServiceImpl ;
	
	// -----------------------------------------------------------------
	
	private Roles rol ;
	
	private RolesDTO rolesDTO ;
	
	@Mock
	private List<RolesDTO> listaRolesDTO = new ArrayList<RolesDTO>() ;
	
	// -----------------------------------------------------------------

	@BeforeEach
	protected void setUp() throws Exception {
		
		this.findByIdHelper = Mockito.mock( FindByIdHelper.class ) ;
		this.iRolesRepository = Mockito.mock( IRolesRepository.class ) ;
		this.mapperUtil = Mockito.mock( MapperUtil.class ) ;
		
		this.rol = Mockito.mock( Roles.class ) ;
		
		this.rolesDTO = Mockito.mock( RolesDTO.class ) ; 
		
	}
	
	// -----------------------------------------------------------------

	@AfterEach
	protected void tearDown() throws Exception {
	}
	
	// -----------------------------------------------------------------

	@Test
	public void testGetAllRoles() {
		
		Mockito.when( this.rolesServiceImpl.getAllRoles() ).thenReturn( this.listaRolesDTO ) ;
		this.listaRolesDTO = this.rolesServiceImpl.getAllRoles() ;
		
		log.info( "datos: " + this.listaRolesDTO ) ;
		
		// not null
		assertNotNull( this.listaRolesDTO ) ;
		
		// two values
		//assertEquals( 2 , this.rolesServiceImpl.getAllRoles().size() ) ;
		
	}
/*
	@Test
	public void testGetRole() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testCreateRole() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUpdateRole() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDeleteRole() {
		throw new RuntimeException("not yet implemented");
	}
*/
}
