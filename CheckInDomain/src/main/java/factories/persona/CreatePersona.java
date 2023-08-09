package factories.persona;

import core.BusinessRuleValidationException;
import model.Persona;

public class CreatePersona implements PersonaFactory {

  @Override
  public Persona create(
    String name,
    String lastname,
    String ci
  ) throws BusinessRuleValidationException {
    return new Persona(name, lastname, ci);
  }
}
