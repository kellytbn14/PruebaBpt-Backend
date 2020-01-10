package com.empresa.sboot.pruebabpt.models.persistence;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
