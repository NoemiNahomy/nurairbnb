package use.cases.command.transaccion.get;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import java.util.UUID;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.TransactionPagoRepository;
import utils.TransaccionMapper;

@Component
public class GetTransactionReservaHandler
    implements Command.Handler<GetTransactionReservaQuery, TransactionPagoDto> {

  private final TransactionPagoRepository propiedadRepository;

  public GetTransactionReservaHandler(TransactionPagoRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public TransactionPagoDto handle(GetTransactionReservaQuery command) {
    try {
      TransaccionPago propiedades =
          propiedadRepository.findByReservaId(UUID.fromString(command.reservaId));
      return TransaccionMapper.from(propiedades);
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
