package com.api.credenciales.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.model.Roles;

@RunWith(MockitoJUnitRunner.class)
public class MapperUtilTest {
	
	@Mock
	private ModelMapper modelMapper ;
	
	@InjectMocks
	private MapperUtil mapperUtil ;
	
	// -----------------------------------------------------------------
	
	private Roles rol ;
	
	private RolesDTO rolDTO ;
	
	// -----------------------------------------------------------------

	@Before
	public void setUp() throws Exception {
		
		this.rol = new Roles() ;
		this.rol.setName( "test01" ) ;
		this.rol.setStatus( true ) ;
		
		this.rolDTO = new RolesDTO() ;
		this.rolDTO.setName( "test01" ) ;
		this.rolDTO.setStatus( true ) ;
		
	}

	// -----------------------------------------------------------------

	@Test
	public void testRoleEntityToRoleDTO() {
		
		RolesDTO rolDTOTest = this.mapperUtil.roleEntityToRoleDTO( this.rol ) ;
		
		assertEquals( this.rolDTO , rolDTOTest ) ;
	}

	@Test
	public void testRoleDTOToRoleEntity() {
		
		Roles rolTest = this.mapperUtil.roleDTOToRoleEntity( rolDTO ) ;
		
		assertEquals( this.rol , rolTest ) ;
		
	}
	
	// -----------------------------------------------------------------
	
	@After
	public void tearDown() throws Exception {
	}

}
