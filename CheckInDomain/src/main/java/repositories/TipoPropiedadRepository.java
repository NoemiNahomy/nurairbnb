package repositories;

import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import model.TipoPropiedad;

public interface TipoPropiedadRepository {

  UUID update(TipoPropiedad tipo);

  List<TipoPropiedad> findTipoPropiedadById(UUID id) throws BusinessRuleValidationException;

  List<TipoPropiedad> getAll() throws BusinessRuleValidationException;
}
