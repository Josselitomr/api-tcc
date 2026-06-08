package com.inventario.domain.usecase;

import com.inventario.domain.model.Producto;
import com.inventario.application.port.ProductoRepositoryPort;
import java.util.List;

public class ObtenerProductosUseCase {
    private final ProductoRepositoryPort repositoryPort;

    public ObtenerProductosUseCase(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public List<Producto> ejecutar() {
        return repositoryPort.obtenerTodos();
    }
}
