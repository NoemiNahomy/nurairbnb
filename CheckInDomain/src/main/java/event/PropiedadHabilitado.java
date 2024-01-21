package event;

import core.DomainEvent;
import java.util.Date;
import model.Propiedad;

public class PropiedadHabilitado extends DomainEvent {
  public Propiedad propiedadHabilitada;

  public PropiedadHabilitado(Propiedad propiedadHabilitada, Date occuredOn) {
    super(occuredOn);
    this.propiedadHabilitada = propiedadHabilitada;
  }
}
