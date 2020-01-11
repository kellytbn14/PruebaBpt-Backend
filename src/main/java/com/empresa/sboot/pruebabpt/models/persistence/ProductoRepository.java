package com.empresa.sboot.pruebabpt.models.persistence;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    //@Query("select p from producto p where p.nitproveedor = ?1")

    @Query(value = "SELECT * FROM producto WHERE nitproveedor = ?1", nativeQuery = true)
    List<Producto> findByNitProveedor(String nitProveedor);

    @Query(value = "SELECT nomproducto,precioproducto FROM producto WHERE precioproducto>=180000 ORDER BY precioproducto DESC ", nativeQuery = true)
    List<Object[]> findByPrecioMayorQue();

    @Query(value = "SELECT nomproducto FROM producto WHERE nitproveedor = ?1", nativeQuery = true)
    List<Object[]> findNameByNitProveedor(String nitProveedor);

    @Query(value = "SELECT nomproducto,precioproducto FROM producto WHERE precioproducto>=20000 AND precioproducto<=180000 ", nativeQuery = true)
    List<Object[]> findByPrecioEntre();
}
