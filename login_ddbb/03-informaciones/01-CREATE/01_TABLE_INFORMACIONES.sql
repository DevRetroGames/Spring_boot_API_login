CREATE TABLE IF NOT EXISTS credenciales.INFORMACIONES (  
    
    -- uuid
    INFORMACIONES_ID VARCHAR(36) DEFAULT ( uuid() ) PRIMARY KEY ,
    
    -- informacion personal
    NAMES VARCHAR( 255 ) NOT NULL ,
    LAST_NAMES VARCHAR( 255 ) NOT NULL ,
    YEARS TINYINT NOT NULL ,
    CELL_PHONO_NUMBER VARCHAR( 255 ) NOT NULL ,
    EMAIL VARCHAR( 255 ) NOT NULL ,

    -- datos de localidad
    DNI VARCHAR( 255 ) UNIQUE ,
    COUNTRY VARCHAR( 255 ) ,
    CITY VARCHAR( 255 ) ,

    -- fechas
    CreationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	ModificationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;