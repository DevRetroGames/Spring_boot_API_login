package com.api.credenciales.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table( name = "IDENTIFICACION" )
public class Identificacion {
	
	@Id
	@GeneratedValue( generator = "hibernate-uuid" )
	@GenericGenerator( name = "uuid" , strategy = "uuid4" )
	@Type( type = "org.hibernate.type.UUIDCharType" )
	@Column( name = "IDEN_ID" , updatable = false , nullable = false )
	private UUID idenId ;
	
	// foreign key of the table information
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "INFO" , referencedColumnName = "INFO_ID" )
	private Informacion informacion ;
	
	@Column( name = "USUARIO" )
	private String usuario ;
	
	@Column( name = "PASS_WORD" )
	private String passWord ;
	
	@Temporal( TemporalType.TIMESTAMP )	
	@Column( name = "CreationDate" , insertable = false, updatable = false )
	private Date creationDate ;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "ModificationDate" , insertable = false, updatable = false )
	private Date modificationDate ;

}
