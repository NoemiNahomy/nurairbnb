package dtos;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetodoPagoDtoTest {

    @Test
    void testConstructorAndGetters() {
        UUID id = UUID.randomUUID();
        String detalle = "Credit card";
        String tipo = "Visa";

        MetodoPagoDto dto = new MetodoPagoDto(id, detalle, tipo);

        assertEquals(id, dto.id);
        assertEquals(detalle, dto.detalle);
        assertEquals(tipo, dto.tipo);
    }


    @Test
    void testToString() {
        String detalle = "Credit card";
        String tipo = "Visa";
        MetodoPagoDto dto = new MetodoPagoDto(null, detalle, tipo);
        String result = dto.toString();

        assertEquals(
                "{detalle:" + detalle + ", type:" + tipo + "}",
                result
        );
    }
}
