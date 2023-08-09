package factories.check.in;

import java.util.List;
import java.util.UUID;
import model.CheckIn;
import model.Persona;
import model.Propiedad;

public class CreateCheckIn implements CheckInFactory {

  @Override
  public CheckIn create(
    UUID flightId,
    List<Propiedad> avaiblePropiedades,
    Persona persona
  ) {
    return new CheckIn(flightId, avaiblePropiedades, persona);
  }
}
