package com.empresa.sboot.pruebabpt.models.persistence;

import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorRepository extends CrudRepository<Proveedor, String> {
}
