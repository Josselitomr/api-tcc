package com.inventario.domain.usecase;

import com.inventario.domain.model.Producto;
import com.inventario.application.port.ProductoRepositoryPort;

public class CrearProductoUseCase {
    private final ProductoRepositoryPort repositoryPort;

    public CrearProductoUseCase(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Producto ejecutar(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es requerido");
        }
        if (producto.getPrecio() == null || producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        return repositoryPort.guardar(producto);
    }
}
