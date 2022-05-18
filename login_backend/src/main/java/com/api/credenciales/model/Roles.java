package com.api.credenciales.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table( name = "ROLES" )
public class Roles {

	@Id
	@GeneratedValue( generator = "hibernate-uuid" )
	@GenericGenerator( name = "uuid" , strategy = "uuid4" )
	@Type( type = "org.hibernate.type.UUIDCharType" )
	@Column( name = "ROLES_ID" , updatable = false , nullable = false )
	private UUID rolesId ;
	
	@Column( name = "NAME" )
	private String name ;
	
	@Column( name = "STATUS" )
	private boolean status ;
	
	// Bidirectional with the table identifications
	@ManyToOne( optional = false , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
	private Identificacion identificacion ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "CreationDate" , insertable = false, updatable = false )
	private Date creationDate ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "ModificationDate" , insertable = false, updatable = false )
	private Date modificationDate ;
	
}
