package utils;

import dtos.PropiedadDto;
import model.Propiedad;

import java.util.UUID;

public final class PropiedadMapper {

    public static PropiedadDto from(Propiedad propiedad) {
        if (propiedad == null) return new PropiedadDto();
        return new PropiedadDto(
                propiedad.getId() == null ? UUID.randomUUID() : propiedad.getId(),
                propiedad.getNombre() == null ? "" : propiedad.getNombre(),
                propiedad.getEstado() == null ? "" : propiedad.getEstado().toString(),
                propiedad.getPrecio().getValue() == 0.0 ? 0.0 : propiedad.getPrecio().getValue()
        );
    }
}