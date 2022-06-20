CREATE TRIGGER SYSTEM.ROLES_SET_MODIFICATION
  before update on SYSTEM.ROLES
  for each row
BEGIN
  :new.ModificationDate := current_timestamp() ;
END ;