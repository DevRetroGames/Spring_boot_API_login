package com.api.credenciales.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table( name = "INFORMACION" )
public class Informacion {
	
	@Id
	@GeneratedValue( generator = "hibernate-uuid" )
	@GenericGenerator( name = "uuid" , strategy = "uuid4" )
	@Type( type = "org.hibernate.type.UUIDCharType" )
	@Column( name = "INFO_ID" , updatable = false , nullable = false )
	private UUID infoId ;
	
	@Column( name = "NOMBRES" )
	private String nombres ;
	
	@Column( name = "APELLIDOS" )
	private String apellidos ;
	
	@Column( name = "EDAD" )
	private int edad ;
	
	@Column( name = "FONO" )
	private String fono ;
	
	@Column( name = "EMAIL" )
	private String email ;
	
	// foreign key of the table roles
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "ROLES" , referencedColumnName = "ROLES_ID" )
	private Roles rol ;
	
	// Bidirectional with the table identification
	@OneToOne( mappedBy = "informacion" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
	private Identificacion identificacion ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "CreationDate" , insertable = false, updatable = false )
	private Date creationDate ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "ModificationDate" , insertable = false, updatable = false )
	private Date modificationDate ;

}
