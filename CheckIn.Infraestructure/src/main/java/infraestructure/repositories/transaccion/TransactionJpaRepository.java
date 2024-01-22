package infraestructure.repositories.transaccion;

import core.BusinessRuleValidationException;
import infraestructure.model.TransactionJpaModel;
import infraestructure.utils.TransaccionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import model.TransaccionPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import repositories.TransactionPagoRepository;

@Repository
public class TransactionJpaRepository implements TransactionPagoRepository {

  @Autowired
  private TransactionCrudRepository seatCrudRepository;

  @Override
  public UUID update(TransaccionPago seat) {
    TransactionJpaModel seatJpaModel = TransaccionUtils.seatToJpaEntity(seat);
    return seatCrudRepository.save(seatJpaModel).getCode();
  }

  /*@Override
  public List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
    throws BusinessRuleValidationException {
    List<TransaccionJpaModel> jpaModels = seatCrudRepository.findByFlightIdAndStatus(
      flightId,
      status
    );
    if (
      jpaModels == null || jpaModels.size() == 0
    ) return Collections.emptyList();
    List<Transaccion> seats = new ArrayList<>();
    for (TransaccionJpaModel jpaModel : jpaModels) {
      seats.add(TransaccionUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }*/

  @Override
  public List<TransaccionPago> findByTransactionCode(UUID flightId)
    throws BusinessRuleValidationException {
    List<TransactionJpaModel> jpaModels = seatCrudRepository.findByCode(flightId);
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    List<TransaccionPago> seats = new ArrayList<>();
    for (TransactionJpaModel jpaModel : jpaModels) {
      seats.add(TransaccionUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }

  @Override
  public List<TransaccionPago> getAll() throws BusinessRuleValidationException {
    List<TransactionJpaModel> jpaModels = Streamable
            .of(seatCrudRepository.findAll())
            .toList();
    List<TransaccionPago> passengers = new ArrayList<>();
    for (TransactionJpaModel jpaModel : jpaModels) {
      passengers.add(TransaccionUtils.jpaModelToSeat(jpaModel));
    }
    return passengers;
  }

  public void setSeatCrudRepository(TransactionCrudRepository seatCrudRepository) {
    this.seatCrudRepository = seatCrudRepository;
  }
}
