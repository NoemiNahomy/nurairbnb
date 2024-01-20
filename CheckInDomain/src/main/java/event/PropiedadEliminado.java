package event;

import core.DomainEvent;
import java.util.Date;
import model.Propiedad;

public class PropiedadEliminado extends DomainEvent {
  public Propiedad propiedadEliminada;

  public PropiedadEliminado(Propiedad propiedadEliminada, Date occuredOn) {
    super(occuredOn);
    this.propiedadEliminada = propiedadEliminada;
  }
}
