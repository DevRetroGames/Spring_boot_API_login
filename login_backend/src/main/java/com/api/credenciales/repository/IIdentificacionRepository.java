package com.api.credenciales.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.credenciales.model.Identifications;
import com.api.credenciales.model.Informacion;

@Repository
public interface IIdentificacionRepository extends JpaRepository< Identifications , UUID > {

	List<Identifications> findByInformacion( Informacion informacion ) ;
	
	Optional<Identifications> findByUsuario( String usuario ) ;
	
}
