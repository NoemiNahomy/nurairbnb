package repositories;

import core.BusinessRuleValidationException;
import model.Propiedad;
import model.TipoPropiedad;

import java.util.List;
import java.util.UUID;

public interface TipoPropiedadRepository {

    UUID update(TipoPropiedad tipo);

    List<TipoPropiedad> findTipoPropiedadById(UUID id)
            throws BusinessRuleValidationException;

    List<TipoPropiedad> getAll() throws BusinessRuleValidationException;
}
