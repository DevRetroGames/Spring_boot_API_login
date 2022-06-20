CREATE TRIGGER SYSTEM.INFORMATIONS_SET_MODIFICATION
  before update on SYSTEM.INFORMATIONS
  for each row
BEGIN
  :new.ModificationDate := current_timestamp() ;
END ;