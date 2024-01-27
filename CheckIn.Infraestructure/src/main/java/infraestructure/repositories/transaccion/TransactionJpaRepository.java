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
	private TransactionCrudRepository transactionCrudRepository;

	@Override
	public UUID update(TransaccionPago pago) {
		TransactionJpaModel seatJpaModel = TransaccionUtils.seatToJpaEntity(pago);
		return transactionCrudRepository.save(seatJpaModel).getCode();
	}

	@Override
	public List<TransaccionPago> findByTransactionCode(UUID pagoId)
			throws BusinessRuleValidationException {
		List<TransactionJpaModel> jpaModels = transactionCrudRepository.findByCode(pagoId);
		if (
				jpaModels == null || jpaModels.isEmpty()
		) return Collections.emptyList();
		List<TransaccionPago> seats = new ArrayList<>();
		for (TransactionJpaModel jpaModel : jpaModels) {
			seats.add(TransaccionUtils.jpaModelToTransaction(jpaModel));
		}
		return seats;
	}

	@Override
	public TransaccionPago findByReservaId(UUID reservaId) throws BusinessRuleValidationException {
		TransactionJpaModel jpaModels = transactionCrudRepository.findByReservaId(reservaId);
		return TransaccionUtils.jpaModelToTransaction(jpaModels);
	}


	@Override
	public List<TransaccionPago> getAll() throws BusinessRuleValidationException {
		List<TransactionJpaModel> jpaModels = Streamable
				.of(transactionCrudRepository.findAll())
				.toList();
		List<TransaccionPago> passengers = new ArrayList<>();
		for (TransactionJpaModel jpaModel : jpaModels) {
			passengers.add(TransaccionUtils.jpaModelToTransaction(jpaModel));
		}
		return passengers;
	}


	public void setTransactionCrudRepository(TransactionCrudRepository transactionCrudRepository) {
		this.transactionCrudRepository = transactionCrudRepository;
	}
}
