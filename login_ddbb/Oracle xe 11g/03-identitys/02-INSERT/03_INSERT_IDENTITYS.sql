-- IDENTITYS_ID
-- INFORMATION 
-- ROL 
-- USERNAME  
-- KEYWORD 
-- STATUS
-- CreationDate     : TIMESTAMP     --
-- ModificationDate : TIMESTAMP     --
INSERT INTO SYSTEM.IDENTITYS( INFORMATION , ROL , USERNAME , KEYWORD , STATUS ) 
VALUES( 
  ( SELECT INFORMATIONS_ID FROM INFORMATIONS WHERE NAMES = 'nombres' ) ,
  ( SELECT ROLES_ID FROM ROLES WHERE NAME = 'dev_admin' ) , 
  'dev' , 
  'dev' ,
  '1'
) ;