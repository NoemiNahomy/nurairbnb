package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.PersonaJpaModel;
import model.Persona;

@Generated
public class PersonaUtils {

  public static PersonaJpaModel passangerToJpaEntity(Persona passanger) {
    PersonaJpaModel passangerJpaModel = new PersonaJpaModel();
    passangerJpaModel.setCi(passanger.getCi());
    passangerJpaModel.setId(passanger.getId());
    passangerJpaModel.setLastname(passanger.getLastname());
    passangerJpaModel.setName(passanger.getName());
    return passangerJpaModel;
  }

  public static Persona jpaModelToPassanger(PersonaJpaModel jpaModel)
    throws BusinessRuleValidationException {
    return new Persona(
      jpaModel.getName(),
      jpaModel.getLastname(),
      jpaModel.getCi()
    );
  }
}
