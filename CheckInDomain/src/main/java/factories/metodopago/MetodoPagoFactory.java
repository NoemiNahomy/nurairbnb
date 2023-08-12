package factories.metodopago;

import core.BusinessRuleValidationException;
import model.MetodoPago;
import model.TipoPropiedad;

import java.util.UUID;

public class MetodoPagoFactory implements MetodoFactory {

    @Override
    public MetodoPago create(UUID id, String detalle, String tipo) throws BusinessRuleValidationException {
        return new MetodoPago(id,detalle,tipo);
    }
}
