package use.cases.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.CheckInDto;
import factories.check.in.CheckInFactory;
import factories.check.in.CreateCheckIn;
import factories.propiedad.PropiedadFactory;

import java.util.List;
import java.util.UUID;
import model.CheckIn;
import model.Persona;
import model.Propiedad;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PersonaRepository;
import repositories.PropiedadRepository;
import utils.CheckInMapper;

@Component
public class CreateCheckInHandler
  implements Command.Handler<CreateCheckInCommand, CheckInDto> {

  private final CheckInRepository checkInRepository;
  private final PropiedadRepository propiedadRepository;
  private final PropiedadFactory propiedadFactory;
  private final CheckInFactory checkInFactory;
  private final PersonaRepository personaRepository;

  public CreateCheckInHandler(
    CheckInRepository checkInRepository,
    PropiedadRepository seatRepository,
    PersonaRepository passangerRepository
  ) {
    this.checkInRepository = checkInRepository;
    this.propiedadRepository = seatRepository;
    this.personaRepository = passangerRepository;
    this.propiedadFactory = new PropiedadFactory();
    this.checkInFactory = new CreateCheckIn();
  }

  @Override
  public CheckInDto handle(CreateCheckInCommand request) {
    try {
      CheckIn checkIn = checkInRepository.findByPersonAndId(
        UUID.fromString(request.checkInDto.persona.id),
        UUID.fromString(request.checkInDto.propiedadId)
      );
      if (checkIn != null) {
        return CheckInMapper.from(checkIn);
      }
      Persona passanger =
        this.personaRepository.get(
            UUID.fromString(request.checkInDto.persona.id)
          );

      List<Propiedad> avaibleSeats = propiedadRepository.findPropiedadById(
        UUID.fromString(request.checkInDto.propiedadId)
      );

      checkIn =
        checkInFactory.create(
          UUID.fromString(request.checkInDto.propiedadId),
          avaibleSeats,
          passanger
        );
      checkInRepository.update(checkIn);
      return CheckInMapper.from(checkIn);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
