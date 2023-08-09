package infraestructure.utils;

import annotations.Generated;
import core.BusinessRuleValidationException;
import infraestructure.model.MetodoPagoJpaModel;
import infraestructure.model.CheckInJpaModel;
import java.util.Collections;
import java.util.List;
import model.MetodoPago;

@Generated
public class MetodoPagoUtils {

  public static MetodoPagoJpaModel baggageToJpaEntity(
    MetodoPago baggage

  ) {
    MetodoPagoJpaModel model = new MetodoPagoJpaModel();
    model.setDetalle(baggage.getDetalle());
    model.setTipo(baggage.getType().toString());
    model.setId(baggage.getId());
    return model;
  }

  public static List<MetodoPagoJpaModel> baggagesToJpaEntities(
    List<MetodoPago> baggages
  ) {
    if (baggages == null) return Collections.emptyList();
    return baggages
      .stream()
      .map((MetodoPago baggage) -> baggageToJpaEntity(baggage))
      .toList();
  }

  public static MetodoPago jpaToBaggage(MetodoPagoJpaModel jpaModel)
    throws BusinessRuleValidationException {
    return new MetodoPago(jpaModel.getDetalle(), jpaModel.getTipo());
  }
}
