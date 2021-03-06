package com.api.credenciales.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "INFORMACIONES" )
public class Informacion {
	
	@Id
	@GeneratedValue( generator = "hibernate-uuid" )
	@GenericGenerator( name = "uuid" , strategy = "uuid4" )
	@Type( type = "org.hibernate.type.UUIDCharType" )
	@Column( name = "INFORMACIONES_ID" , updatable = false , nullable = false )
	private UUID informacionesId ;
	
	@Column( name = "NAMES" )
	private String names ;
	
	@Column( name = "LAST_NAMES" )
	private String lastNames ;
	
	@Column( name = "YEARS" )
	private int years ;
	
	@Column( name = "CELL_PHONO_NUMBER" )
	private String cellPhonoNumber ;
	
	@Column( name = "EMAIL" )
	private String email ;
	
	@Column( name = "DNI" )
	private String dni ;
	
	@Column( name = "COUNTRY" )
	private String country ;
	
	@Column( name = "CITY" )
	private String city ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "CreationDate" , insertable = false, updatable = false )
	private Date creationDate ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "ModificationDate" , insertable = false, updatable = false )
	private Date modificationDate ;
	
	@OneToOne( mappedBy = "informacion" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
	private Identificacion identificacion ;

}
