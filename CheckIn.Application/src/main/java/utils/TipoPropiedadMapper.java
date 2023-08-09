package utils;

import dtos.PropiedadDto;
import dtos.TipoPropiedadDto;
import model.Propiedad;
import model.TipoPropiedad;

import java.util.UUID;

public final class TipoPropiedadMapper {

    public static TipoPropiedadDto from(TipoPropiedad tipo) {
        if (tipo == null) return new TipoPropiedadDto();
        return new TipoPropiedadDto(
                tipo.getId() == null ? UUID.randomUUID() : tipo.getId(),
                tipo.getNombreTipo() == null ? "" : tipo.getNombreTipo()

        );
    }


}