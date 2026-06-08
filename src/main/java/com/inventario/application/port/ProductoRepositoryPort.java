package com.inventario.application.port;

import com.inventario.domain.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto guardar(Producto producto);
    Optional<Producto> obtenerPorId(Long id);
    List<Producto> obtenerTodos();
    Producto actualizar(Producto producto);
    void eliminar(Long id);
}
