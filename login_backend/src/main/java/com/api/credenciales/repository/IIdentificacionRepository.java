package com.api.credenciales.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.credenciales.model.Identificacion;

@Repository
public interface IIdentificacionRepository extends JpaRepository< Identificacion , UUID > {

}
