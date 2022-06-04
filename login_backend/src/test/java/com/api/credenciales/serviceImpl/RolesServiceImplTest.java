package com.api.credenciales.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.helper.FindByIdHelper;
import com.api.credenciales.model.Roles;
import com.api.credenciales.repository.IRolesRepository;
import com.api.credenciales.util.MapperUtil;

import lombok.extern.log4j.Log4j2;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource( locations = "classpath:application.properties" )
@Log4j2
public class RolesServiceImplTest {
	
	@Mock
	private FindByIdHelper findByIdHelper;

	@Mock
	private IRolesRepository iRolesRepository;

	@Mock
	private MapperUtil mapperUtil;
	
	@InjectMocks
	private RolesServiceImpl rolesServiceImpl;
	
	// -----------------------------------------------------------------
	
	private Roles rol ;
	
	private RolesDTO rolesDTO ;
	
	@Mock
	private List<RolesDTO> listaRolesDTO  ;
	
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
		
		log.info( "datos: " + this.rolesServiceImpl.getAllRoles() ) ;
		
		// not null
		assertNotNull( this.listaRolesDTO ) ;
		
		// two values
		assertEquals( 2 , this.rolesServiceImpl.getAllRoles().size() ) ;
		
	}
/*
	@Test
	public void testGetRole() {

		Mockito.when( this.rolesServiceImpl.getAllRoles() ).thenReturn( this.listaRolesDTO ) ;
		this.listaRolesDTO = this.rolesServiceImpl.getAllRoles() ;
		
		assertNotNull( this.listaRolesDTO ) ;
		
		UUID roleID = this.listaRolesDTO.get(0).getRolesId() ;
		log.info( "roleID: " + roleID ) ;
		
		Mockito.when( this.rolesServiceImpl.getRole( roleID ) ).thenReturn( rolesDTO ) ;
		this.rolesDTO = this.rolesServiceImpl.getRole( roleID ) ;
		
		assertNotNull( rolesDTO ) ;
		
	}
/*
	@Test
	public void testCreateRole() {
	}

	@Test
	public void testUpdateRole() {
	}

	@Test
	public void testDeleteRole() {
	}
*/
}
