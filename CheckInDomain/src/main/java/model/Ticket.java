package model;

import core.Entity;
import java.util.UUID;

public class Ticket extends Entity {

  Persona passanger;
  UUID flightId;
  UUID bookingId;

  public Ticket(Persona passanger, UUID flightId, UUID bookingId) {
    this.id = UUID.randomUUID();
    this.passanger = passanger;
    this.flightId = flightId;
    this.bookingId = bookingId;
  }

  public Ticket(UUID id, Persona passanger, UUID flightId, UUID bookingId) {
    this.id = id;
    this.passanger = passanger;
    this.flightId = flightId;
    this.bookingId = bookingId;
  }

  public Persona getPassanger() {
    return passanger;
  }

  public UUID getFlightId() {
    return flightId;
  }

  public UUID getBookingId() {
    return bookingId;
  }
}
