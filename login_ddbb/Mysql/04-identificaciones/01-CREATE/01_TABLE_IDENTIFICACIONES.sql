CREATE TABLE IF NOT EXISTS credenciales.IDENTIFICACIONES (  
    
    -- uuid
    IDENTIFICACIONES_ID VARCHAR(36) DEFAULT ( uuid() ) PRIMARY KEY ,
    
    -- fk de la tabla informacion
    INFORMACION VARCHAR(36) ,

    -- fk de la tabla roles
    ROL VARCHAR(36) ,

    -- credenciales de acceso
    USUARIO VARCHAR( 255 ) NOT NULL ,
    PASS_WORD VARCHAR( 255 ) NOT NULL ,

    -- 0: no activo 
    -- 1: activo
    STATUS BOOLEAN DEFAULT 0 ,

    -- fechas
    CreationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	ModificationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
    
    -- fk hacia la tabla roles
    FOREIGN KEY ( INFORMACION ) REFERENCES INFORMACIONES( INFORMACIONES_ID )
    ON DELETE RESTRICT
    ON UPDATE CASCADE ,

    -- fk hacia la tabla roles
    FOREIGN KEY ( ROL ) REFERENCES ROLES( ROLES_ID )
    ON DELETE SET NULL 
    ON UPDATE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;