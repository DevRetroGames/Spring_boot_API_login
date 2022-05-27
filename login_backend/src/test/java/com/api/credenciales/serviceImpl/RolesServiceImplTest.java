package com.api.credenciales.serviceImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.credenciales.helper.FindByIdHelper;
import com.api.credenciales.repository.IRolesRepository;
import com.api.credenciales.util.MapperUtil;

@ExtendWith(MockitoExtension.class)
public class RolesServiceImplTest {
	
	@Mock
	private FindByIdHelper findByIdHelper;

	@Mock
	private IRolesRepository iRolesRepository;

	@Mock
	private MapperUtil mapperUtil;
	
	@InjectMocks
	private RolesServiceImpl rolesServiceImpl;

	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	public void testGetAllRoles() {
		throw new RuntimeException("not yet implemented");
	}

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

}
