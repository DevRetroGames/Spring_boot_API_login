INSERT INTO IDENTIFICACIONES( 
  INFORMACION , 
  ROL ,
  USUARIO , 
  PASS_WORD 
) 
VALUES( 
  ( SELECT INFORMACIONES_ID 
    FROM INFORMACIONES 
    WHERE NAMES = "Alejandro Jesus" 
  ) ,
  ( SELECT ROLES_ID 
    FROM ROLES 
    WHERE NAME = "dev_admin" 
  ) , 
  "dev" , 
  "dev" 
) ;