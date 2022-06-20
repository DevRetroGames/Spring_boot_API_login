-- role_id          : UUID          -- desc: UUID
-- name             : Admin         -- desc: nombre del rol
-- status           : 1             -- desc: rol activo  
-- CreationDate     : TIMESTAMP     --
-- ModificationDate : TIMESTAMP     --
INSERT INTO "SYSTEM"."ROLES" ( NAME , STATUS ) 
VALUES ( 'dev_admin' , '1' ) ;

-- nombre:    -- desc: secretaria
-- estado: 1  -- desc: rol activo
INSERT INTO "SYSTEM"."ROLES" ( NAME , STATUS ) 
VALUES ( 'secretaria' , '1' ) ;