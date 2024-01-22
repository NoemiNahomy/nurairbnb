package event;

import core.DomainEvent;
import java.util.Date;
import model.Propiedad;

public class PropiedadModificada extends DomainEvent {

  public Propiedad propiedadModificada;

  public PropiedadModificada(Propiedad propiedadModificada, Date occuredOn) {
    super(occuredOn);
    this.propiedadModificada = propiedadModificada;
  }
}
