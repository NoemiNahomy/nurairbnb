package factories.persona;

import core.BusinessRuleValidationException;
import model.Persona;

public interface PersonaFactory {
  Persona create(
    String name,
    String lastname,
    String ci

  ) throws BusinessRuleValidationException;
}
