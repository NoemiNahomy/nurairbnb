package infraestructure.utils;

import core.BusinessRuleValidationException;
import infraestructure.model.TipoPropiedadJpaModel;
import model.TipoPropiedad;

import java.util.Collections;
import java.util.List;

public class TipoPropiedadUtils {


    public static TipoPropiedadJpaModel tipoToJpaEntity(TipoPropiedad tipo) {
        if (tipo == null) return null;
        TipoPropiedadJpaModel tipoPropiedadJpaModel = new TipoPropiedadJpaModel();
        tipoPropiedadJpaModel.setId(tipo.getId());
        tipoPropiedadJpaModel.setNombreTipo(tipo.getNombreTipo());
        return tipoPropiedadJpaModel;
    }

    public static List<TipoPropiedadJpaModel> seatsToJpaEntities(List<TipoPropiedad> tipo) {
        if (tipo == null) return Collections.emptyList();
        return tipo.stream().map(TipoPropiedadUtils::tipoToJpaEntity).toList();
    }

    public static TipoPropiedad jpaModelToTipoPropiedad(TipoPropiedadJpaModel jpaModel)
            throws BusinessRuleValidationException {
        return new TipoPropiedad(
                jpaModel.getId(),
                jpaModel.getNombreTipo()

        );
    }
}
