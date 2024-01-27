package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.TransactionJpaModel;

import java.util.Collections;
import java.util.List;

import model.TransaccionPago;

@Generated
public class TransaccionUtils {

	public static TransactionJpaModel seatToJpaEntity(TransaccionPago pago) {
		if (pago == null) return null;
		TransactionJpaModel seatJpaModel = new TransactionJpaModel();
		seatJpaModel.setDescripcion(pago.getDescripcion());
		seatJpaModel.setCode(pago.getCode());
		seatJpaModel.setMonto(pago.getMonto());
		seatJpaModel.setEstado(pago.getEstado());
		seatJpaModel.setMetodopagoId(pago.getMetodopagoId());
		seatJpaModel.setReservaId(pago.getReservaId());
		seatJpaModel.setPropiedadId(pago.getPropiedadId());
		seatJpaModel.setPersonaId(pago.getPersonaId());
		seatJpaModel.setFechaPago(pago.getFechaPago());
		seatJpaModel.setNumeroTarjeta(pago.getNumeroTarjeta());
		seatJpaModel.setFechaVencimiento(pago.getFechaVencimiento());
		seatJpaModel.setCvc(pago.getCvc());

		return seatJpaModel;
	}

	public static List<TransactionJpaModel> seatsToJpaEntities(List<TransaccionPago> seats) {
		if (seats == null) return Collections.emptyList();
		return seats.stream().map(TransaccionUtils::seatToJpaEntity).toList();
	}


	public static TransaccionPago jpaModelToTransaction(TransactionJpaModel jpaModel) throws BusinessRuleValidationException {
		return new TransaccionPago(jpaModel.getCode(), jpaModel.getDescripcion(), jpaModel.getMonto(), jpaModel.getEstado(),
				jpaModel.getMetodopagoId(), jpaModel.getReservaId(), jpaModel.getPropiedadId(), jpaModel.getPersonaId(), jpaModel.getFechaPago(), jpaModel.getNumeroTarjeta(),jpaModel.getFechaVencimiento(), jpaModel.getCvc());
	}
}
