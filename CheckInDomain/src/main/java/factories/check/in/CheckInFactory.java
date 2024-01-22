package factories.check.in;

import java.util.List;
import java.util.UUID;
import model.CheckIn;
import model.Persona;
import model.Propiedad;

public interface CheckInFactory {
  CheckIn create(UUID flightId, List<Propiedad> avaiblePropiedades, Persona passanger);
}
