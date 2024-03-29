package model;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import event.CheckInCompleted;
import event.PropiedadAssigned;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckIn extends AggregateRoot {

  private UUID propiedadId;
  private Date date;
  private Propiedad propiedad;
  // private List<Baggage> baggages;
  private List<Propiedad> avaiblePropiedades;
  private Persona persona;

  public CheckIn(UUID propiedadId, List<Propiedad> propiedadListAvailable, Persona persona) {
    this.propiedadId = propiedadId;
    this.avaiblePropiedades = propiedadListAvailable;
    this.persona = persona;
    this.date = new Date();
  }

  public CheckIn(
      UUID id,
      UUID propiedadId,
      Date date,
      Propiedad propiedad,
      List<Propiedad> avaiblePropiedades,
      Persona persona) {
    this.id = id;
    this.propiedadId = propiedadId;
    this.date = date;
    this.propiedad = propiedad;
    this.avaiblePropiedades = avaiblePropiedades;
    this.persona = persona;
  }

  public void assignPropiedad(UUID propiedadCode) throws BusinessRuleValidationException {
    Propiedad targetSeat =
        avaiblePropiedades.stream()
            .filter(s -> s.getId().equals(propiedadCode))
            .findFirst()
            .orElse(null);
    if (targetSeat == null)
      throw new BusinessRuleValidationException("This propiedadCode is not valid" + propiedadCode);
    if (targetSeat.getEstado().equals(Estado.INHABILITADO)) {
      throw new BusinessRuleValidationException(
          "This propiedadCode is already booked" + propiedadCode);
    }

    /*if (this.propiedad != null) {
      this.oldSeat = this.seat;
      this.propiedad.updateStatus(SeatStatus.FREE);
    }*/
    // targetSeat.updateStatus(SeatStatus.BOOKED);
    this.propiedad = targetSeat;
    addDomainEvent(new PropiedadAssigned(this));
    completeCheckIn();
  }

  public void completeCheckIn() {
    if (this.propiedad != null) addDomainEvent(new CheckInCompleted(this));
  }

  public UUID getPropiedadId() {
    return propiedadId;
  }

  public Date getDate() {
    return date;
  }

  public Propiedad getPropiedad() {
    return propiedad;
  }

  public List<Propiedad> getAvaiblePropiedades() {
    return avaiblePropiedades;
  }

  public Persona getPersona() {
    return persona;
  }
}
