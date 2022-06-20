CREATE TABLE SYSTEM.IDENTITYS (  
    
    -- guid
    IDENTITYS_ID RAW( 44 ) DEFAULT SYS_GUID() NOT NULL ,
    
    -- fk of information table
    INFORMATION RAW( 44 ) NOT NULL ,

    -- fk of roles table
    ROL RAW( 44 ) ,

    -- access credentials
    USERNAME VARCHAR2( 255 ) NOT NULL ,
    KEYWORD VARCHAR2( 255 ) NOT NULL ,

    -- 0: off
    -- 1: on
    STATUS NUMBER( 1 ) DEFAULT 0 NOT NULL ,

    -- fechas
    CreationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
	ModificationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,

    -- primary key
    CONSTRAINT identitys_id_pk PRIMARY KEY ( IDENTITYS_ID ) ,

    -- status boolean
    CONSTRAINT identitys_status_ischk CHECK ( STATUS IN ( 1 , 0 ) ) ,
    
    -- fk to informations table
    CONSTRAINT fk_informations
        FOREIGN KEY ( INFORMATION ) REFERENCES INFORMATIONS( INFORMATIONS_ID )
        ON DELETE CASCADE ,

    -- fk to roles table
    CONSTRAINT fk_roles
        FOREIGN KEY ( ROL ) REFERENCES ROLES( ROLES_ID )
        ON DELETE SET NULL

) ;