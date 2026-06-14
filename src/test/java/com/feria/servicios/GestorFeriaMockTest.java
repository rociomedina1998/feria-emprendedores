package com.feria.servicios;

import com.feria.utils.IValidadorEmprendedor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class GestorFeriaMockTest {

    @Test
    void deberiaRegistrarEmprendedorConMock() {

        IValidadorEmprendedor mockValidador =
                mock(IValidadorEmprendedor.class);

        when(mockValidador.validarNombre(anyString()))
                .thenReturn(true);

        when(mockValidador.validarEmail(anyString()))
                .thenReturn(true);

        GestorFeria gestor =
                new GestorFeria(mockValidador);

        gestor.registrarEmprendedorConProductos(
                "Ana",
                "E001",
                "12345678",
                "ana@mail.com",
                "comida",
                List.of("Empanadas"),
                List.of(500.0),
                List.of(10)
        );

        assertEquals(1, gestor.getEmprendedores().size());
    }
}
