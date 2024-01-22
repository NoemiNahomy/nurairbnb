package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.TransactionJpaModel;

import java.util.Collections;
import java.util.List;

import model.TransaccionPago;

@Generated
public class TransaccionUtils {

	public static TransactionJpaModel seatToJpaEntity(TransaccionPago seat) {
		if (seat == null) return null;
		TransactionJpaModel seatJpaModel = new TransactionJpaModel();
		seatJpaModel.setDescripcion(seat.getDescripcion());
		seatJpaModel.setCode(seat.getCode());
		seatJpaModel.setMonto(seat.getMonto());

		return seatJpaModel;
	}

	public static List<TransactionJpaModel> seatsToJpaEntities(List<TransaccionPago> seats) {
		if (seats == null) return Collections.emptyList();
		return seats.stream().map(TransaccionUtils::seatToJpaEntity).toList();
	}

	public static TransaccionPago jpaModelToSeat(TransactionJpaModel jpaModel) throws BusinessRuleValidationException {
		return new TransaccionPago(jpaModel.getCode(), jpaModel.getDescripcion(), jpaModel.getMonto());
	}
}
