package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.Persona;

public interface PersonaRepository {
  UUID update(Persona passanger);

  Persona get(UUID id) throws BusinessRuleValidationException;

  List<Persona> getAll() throws BusinessRuleValidationException;
}
