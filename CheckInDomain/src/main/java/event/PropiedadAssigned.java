package event;

import core.DomainEvent;
import model.CheckIn;

public class PropiedadAssigned extends DomainEvent {

  private CheckIn checkIn;

  public PropiedadAssigned(CheckIn checkIn) {
    super(checkIn.getDate());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
