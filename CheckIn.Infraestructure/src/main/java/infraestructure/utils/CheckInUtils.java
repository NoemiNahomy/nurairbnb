package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PropiedadJpaModel;

import java.util.ArrayList;
import java.util.List;

import model.*;

@Generated
public class CheckInUtils {

  public static CheckIn jpaModelToCheckIn(
    CheckInJpaModel jpaModel,
    List<PropiedadJpaModel> propiedades
  ) throws BusinessRuleValidationException {
    if (jpaModel == null) return null;
    List<Propiedad> seatsAvailable = new ArrayList<>();
    for (PropiedadJpaModel seatJpaModel : propiedades) {
      seatsAvailable.add(PropiedadUtils.jpaModelToPropiedad(seatJpaModel));
    }
    /*Persona persona = null;
    if (jpaModel.getPersona() != null) {
      persona = PropiedadUtils.jpaModelToPropiedad(jpaModel.getPropiedad());
    }*/

    /*List<MetodoPago> baggages = new ArrayList<>();
    for (MetodoPagoJpaModel baggageJpaModel : jpaModel.getBaggages()) {
      baggages.add(MetodoPagoUtils.jpaToBaggage(baggageJpaModel));
    }**/

    return new CheckIn(
      jpaModel.getId(),
      jpaModel.getPropiedadId(),
      jpaModel.getDate(),
      PropiedadUtils.jpaModelToPropiedad(jpaModel.getPropiedad()),
      seatsAvailable,
      PersonaUtils.jpaModelToPassanger(jpaModel.getPersona())
    );

  }
}
