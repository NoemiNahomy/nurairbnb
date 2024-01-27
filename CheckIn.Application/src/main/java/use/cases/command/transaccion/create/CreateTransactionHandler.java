package use.cases.command.transaccion.create;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;
import dtos.TransactionPagoDto;
import factories.transaccion.TransactionPagoFactory;
import model.TransaccionPago;
import org.springframework.stereotype.Component;
import repositories.TransactionPagoRepository;
import utils.TransaccionMapper;

@Component
public class CreateTransactionHandler
    implements Command.Handler<CreateTransactionCommand, TransactionPagoDto> {

  private final TransactionPagoRepository transactionPagoRepository;

  private final TransactionPagoFactory transactionPagoFactory;

  public CreateTransactionHandler(TransactionPagoRepository transactionPagoRepository) {

    this.transactionPagoRepository = transactionPagoRepository;

    this.transactionPagoFactory = new TransactionPagoFactory();
  }

  @Override
  public TransactionPagoDto handle(CreateTransactionCommand request) {
    try {

      TransaccionPago transaccionPago =
          transactionPagoFactory.create(
              request.pago.code.toString(),
              request.pago.descripcion,
              request.pago.monto,
              request.pago.estado,
              request.pago.metodopagoId,
              request.pago.reservaId,
              request.pago.propiedadId,
              request.pago.personaId,
              request.pago.fechaPago,
              request.pago.numeroTarjeta,
              request.pago.fechaVencimiento,
              request.pago.cvc);
      transactionPagoRepository.update(transaccionPago);
      return TransaccionMapper.from(transaccionPago);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
