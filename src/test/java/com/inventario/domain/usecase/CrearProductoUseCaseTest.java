package com.inventario.domain.usecase;

import com.inventario.domain.model.Producto;
import com.inventario.application.port.ProductoRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CrearProductoUseCaseTest {
    private CrearProductoUseCase useCase;

    @Mock
    private ProductoRepositoryPort repositoryPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        useCase = new CrearProductoUseCase(repositoryPort);
    }

    @Test
    void testCrearProductoExitoso() {
        Producto producto = new Producto(null, "Laptop", "Laptop HP", 2500000.0, 10);
        Producto productoGuardado = new Producto(1L, "Laptop", "Laptop HP", 2500000.0, 10);

        when(repositoryPort.guardar(producto)).thenReturn(productoGuardado);

        Producto resultado = useCase.ejecutar(producto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Laptop", resultado.getNombre());
        verify(repositoryPort, times(1)).guardar(producto);
    }

    @Test
    void testCrearProductoSinNombre() {
        Producto producto = new Producto(null, "", "Laptop HP", 2500000.0, 10);

        assertThrows(IllegalArgumentException.class, () -> useCase.ejecutar(producto));
        verify(repositoryPort, never()).guardar(producto);
    }

    @Test
    void testCrearProductoPrecioInvalido() {
        Producto producto = new Producto(null, "Laptop", "Laptop HP", -100.0, 10);

        assertThrows(IllegalArgumentException.class, () -> useCase.ejecutar(producto));
        verify(repositoryPort, never()).guardar(producto);
    }
}
