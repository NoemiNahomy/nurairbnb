package event;

import core.DomainEvent;
import model.Propiedad;

import java.util.Date;

public class PropiedadModificada extends DomainEvent {

    public Propiedad propiedadModificada;
    public PropiedadModificada(Propiedad propiedadModificada, Date occuredOn) {
        super(occuredOn);
        this.propiedadModificada = propiedadModificada;
    }
}
