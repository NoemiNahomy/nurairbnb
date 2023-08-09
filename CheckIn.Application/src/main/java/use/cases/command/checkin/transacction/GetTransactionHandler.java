package use.cases.command.checkin.transacction;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionDto;
import java.util.List;
import java.util.UUID;
import model.Transaccion;
import org.springframework.stereotype.Component;
import repositories.TransactionRepository;
import utils.TransaccionMapper;

@Component
public class GetTransactionHandler
  implements Command.Handler<GetTransactionQuery, List<TransactionDto>> {

  private final TransactionRepository seatRepository;

  public GetTransactionHandler(TransactionRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public List<TransactionDto> handle(GetTransactionQuery command) {
    try {
      List<Transaccion> seats = seatRepository.findByTransactionCode(
        UUID.fromString(command.flightId)
      );
      return seats.stream().map(TransaccionMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
