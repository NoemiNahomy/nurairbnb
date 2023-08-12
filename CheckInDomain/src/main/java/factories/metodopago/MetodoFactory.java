package factories.metodopago;

import core.BusinessRuleValidationException;
import model.MetodoPago;

import java.util.UUID;

public interface MetodoFactory {
    MetodoPago create(UUID id, String detalle, String tipo) throws BusinessRuleValidationException;
}
