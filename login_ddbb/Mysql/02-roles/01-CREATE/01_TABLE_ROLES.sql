CREATE TABLE IF NOT EXISTS credenciales.ROLES (  
    
    -- uuid
    ROLES_ID VARCHAR(36) DEFAULT ( UUID() ) PRIMARY KEY ,
    
    -- nombre del rol
    NAME VARCHAR( 255 ) NOT NULL ,

    -- 0: no activo 
    -- 1: activo
    STATUS BOOLEAN DEFAULT 0 ,

    -- fechas
    CreationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	ModificationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;