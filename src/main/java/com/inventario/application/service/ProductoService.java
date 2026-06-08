package com.inventario.application.service;

import com.inventario.domain.model.Producto;
import com.inventario.domain.usecase.CrearProductoUseCase;
import com.inventario.domain.usecase.ObtenerProductosUseCase;
import com.inventario.application.port.ProductoRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepositoryPort repositoryPort;
    private final CrearProductoUseCase crearProductoUseCase;
    private final ObtenerProductosUseCase obtenerProductosUseCase;

    public ProductoService(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
        this.crearProductoUseCase = new CrearProductoUseCase(repositoryPort);
        this.obtenerProductosUseCase = new ObtenerProductosUseCase(repositoryPort);
    }

    public Producto crearProducto(Producto producto) {
        return crearProductoUseCase.ejecutar(producto);
    }

    public List<Producto> obtenerTodos() {
        return obtenerProductosUseCase.ejecutar();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repositoryPort.obtenerPorId(id);
    }

    public Producto actualizar(Producto producto) {
        return repositoryPort.actualizar(producto);
    }

    public void eliminar(Long id) {
        repositoryPort.eliminar(id);
    }
}
