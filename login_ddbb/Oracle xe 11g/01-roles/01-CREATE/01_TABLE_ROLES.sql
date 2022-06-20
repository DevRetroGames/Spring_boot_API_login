CREATE TABLE SYSTEM.ROLES (

    -- guid 
    ROLES_ID RAW( 44 ) DEFAULT SYS_GUID() NOT NULL ,

    -- rol name
    NAME VARCHAR2( 255 ) NOT NULL ,

    -- 0: off
    -- 1: on
    STATUS NUMBER( 1 ) DEFAULT 0 NOT NULL ,

    -- dates
    CreationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
	ModificationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    
    -- primary key
    CONSTRAINT roles_id_pk PRIMARY KEY ( ROLES_ID ) ,
    
    -- status boolean
    CONSTRAINT roles_status_ischk CHECK ( STATUS IN ( 1 , 0 ) )
    
) ;