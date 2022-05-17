package com.api.credenciales.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.credenciales.model.Informacion;
import com.api.credenciales.model.Roles;

@Repository
public interface IInformacionRepository extends JpaRepository< Informacion , UUID > {

	List<Informacion> findByRol( Roles rol ) ;
	
}
