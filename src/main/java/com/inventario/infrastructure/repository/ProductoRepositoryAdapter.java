package com.inventario.infrastructure.repository;

import com.inventario.domain.model.Producto;
import com.inventario.application.port.ProductoRepositoryPort;
import com.inventario.infrastructure.persistence.ProductoEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {
    private final ProductoJpaRepository jpaRepository;

    public ProductoRepositoryAdapter(ProductoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Producto guardar(Producto producto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(producto.getNombre());
        entity.setDescripcion(producto.getDescripcion());
        entity.setPrecio(producto.getPrecio());
        entity.setStock(producto.getStock());
        
        ProductoEntity saved = jpaRepository.save(entity);
        return entityToModel(saved);
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return jpaRepository.findById(id).map(this::entityToModel);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Producto actualizar(Producto producto) {
        ProductoEntity entity = jpaRepository.findById(producto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        
        entity.setNombre(producto.getNombre());
        entity.setDescripcion(producto.getDescripcion());
        entity.setPrecio(producto.getPrecio());
        entity.setStock(producto.getStock());
        
        ProductoEntity updated = jpaRepository.save(entity);
        return entityToModel(updated);
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }

    private Producto entityToModel(ProductoEntity entity) {
        return new Producto(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getStock()
        );
    }
}
