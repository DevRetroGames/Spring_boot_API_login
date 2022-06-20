CREATE TABLE SYSTEM.INFORMATIONS (  
    
    -- guid
    INFORMATIONS_ID RAW( 44 ) DEFAULT SYS_GUID() NOT NULL ,
    
    -- personal information
    NAMES VARCHAR2( 255 ) NOT NULL ,
    LAST_NAMES VARCHAR2( 255 ) NOT NULL ,
    YEARS NUMBER( 2 , 0 ) NOT NULL ,
    CELL_PHONO_NUMBER VARCHAR2( 255 ) NOT NULL ,
    EMAIL VARCHAR2( 255 ) NOT NULL ,

    -- locality data
    DNI VARCHAR2( 255 ) NOT NULL ,
    COUNTRY VARCHAR2( 255 ) NOT NULL ,
    CITY VARCHAR2( 255 ) NOT NULL ,

    -- dates
    CreationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
	ModificationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,

    -- primary key
    CONSTRAINT informations_id_pk PRIMARY KEY ( INFORMATIONS_ID ) ,

    -- 
    CONSTRAINT unique_constraint_email UNIQUE ( EMAIL ) ,

    -- 
    CONSTRAINT unique_constraint_dni UNIQUE ( DNI ) 

) ;