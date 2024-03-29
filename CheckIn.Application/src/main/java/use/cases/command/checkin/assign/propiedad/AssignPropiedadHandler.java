package use.cases.command.checkin.assign.propiedad;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.PropiedadDto;
import java.util.UUID;
import model.CheckIn;
import org.springframework.stereotype.Component;
import repositories.CheckInRepository;
import repositories.PropiedadRepository;
import utils.PropiedadMapper;

@Component
public class AssignPropiedadHandler
    implements Command.Handler<AssignPropiedadCommand, PropiedadDto> {

  private final CheckInRepository checkInRepository;
  private final PropiedadRepository propiedadRepository;

  public AssignPropiedadHandler(
      CheckInRepository checkInRepository, PropiedadRepository seatRepository) {
    this.checkInRepository = checkInRepository;
    this.propiedadRepository = seatRepository;
  }

  @Override
  public PropiedadDto handle(AssignPropiedadCommand request) {
    try {
      CheckIn checkIn =
          checkInRepository.findByPersonAndId(
              UUID.fromString(request.checkInDto.persona.id),
              UUID.fromString(request.checkInDto.propiedadId));
      checkIn.assignPropiedad(UUID.fromString(request.checkInDto.propiedad.id.toString()));
      checkInRepository.update(checkIn);
      propiedadRepository.update(checkIn.getPropiedad());

      PropiedadDto seatDto = PropiedadMapper.from(checkIn.getPropiedad());
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(seatDto);
      return seatDto;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
