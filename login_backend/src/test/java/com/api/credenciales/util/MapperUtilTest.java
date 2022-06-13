package com.api.credenciales.util;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.api.credenciales.dto.RolesDTO;
import com.api.credenciales.model.Roles;

@ExtendWith(MockitoExtension.class)
public class MapperUtilTest {
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private MapperUtil mapperUtil;

	// -----------------------------------------------------------------
	
	private Roles rol ;
	
	private RolesDTO rolDTO ;

	// -----------------------------------------------------------------
	
	@BeforeEach
	protected void setUp() throws Exception {
		
		this.mapperUtil = Mockito.mock( MapperUtil.class ) ;
		
		this.rol = Mockito.mock( Roles.class ) ;
		this.rol.setName( "test01" ) ;
		this.rol.setStatus( true ) ;
		
		this.rolDTO = Mockito.mock( RolesDTO.class ) ;
		this.rolDTO.setName( "test01" ) ;
		this.rolDTO.setStatus( true ) ;
		
	}

	// -----------------------------------------------------------------
	
	@AfterEach
	protected void tearDown() throws Exception {
	}

	// -----------------------------------------------------------------
	
	@Test
	public void testRoleEntityToRoleDTO() {
		
		Mockito.when( this.mapperUtil.roleEntityToRoleDTO( this.rol ) ).thenReturn( rolDTO ) ;
		RolesDTO rolDTOTest = this.mapperUtil.roleEntityToRoleDTO( this.rol ) ;
		
		// name equals
		assertEquals( this.rolDTO.getName() , rolDTOTest.getName() ) ;
		
		// status equals
		assertEquals( this.rolDTO.isStatus() , rolDTOTest.isStatus() ) ;
		
		// dto equals
		assertEquals( this.rolDTO , rolDTOTest ) ;
		
	}

	@Test
	public void testRoleDTOToRoleEntity() {
		
		Mockito.when( this.mapperUtil.roleDTOToRoleEntity( this.rolDTO ) ).thenReturn( rol ) ;
		Roles rolTest = this.mapperUtil.roleDTOToRoleEntity( rolDTO ) ;
		
		// name equals
		assertEquals( this.rol.getName() , rolTest.getName() ) ;
		
		// status equals
		assertEquals( this.rol.isStatus() , rolTest.isStatus() ) ;
		
		// dto equals
		assertEquals( this.rol , rolTest ) ;
		
	}

}
