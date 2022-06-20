CREATE TRIGGER SYSTEM.IDENTITYS_SET_MODIFICATION
  before update on SYSTEM.IDENTITYS
  for each row
BEGIN
  :new.ModificationDate := current_timestamp() ;
END ;