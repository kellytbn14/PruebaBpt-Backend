package com.empresa.sboot.pruebabpt.models.persistence;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProveedorRepository extends CrudRepository<Proveedor, String> {

    @Query(value = "SELECT nomproveedor FROM proveedor,producto WHERE proveedor.nit=producto.nitproveedor AND producto.codproducto = ?1", nativeQuery = true)
    List<Object[]> findByCodProducto(Long codigo);

}
