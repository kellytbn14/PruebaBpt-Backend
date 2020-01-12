package com.empresa.sboot.pruebabpt.models.persistence;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, String> {

    //@Query("select p from producto p where p.nitproveedor = ?1")

    @Query(value = "SELECT * FROM producto WHERE nitproveedor = ?1", nativeQuery = true)
    List<Producto> findByNitProveedor(String nitProveedor);

    @Query(value = "SELECT nomproducto,precioproducto FROM producto WHERE precioproducto>=?1 ORDER BY precioproducto DESC ", nativeQuery = true)
    List<Object[]> findByPrecioMayorQue(int valor);

    @Query(value = "SELECT nomproducto FROM producto WHERE nitproveedor = ?1", nativeQuery = true)
    List<Object[]> findNameByNitProveedor(String nitProveedor);

    @Query(value = "SELECT nomproducto,precioproducto FROM producto WHERE precioproducto>=?1 AND precioproducto<=?2 ", nativeQuery = true)
    List<Object[]> findByPrecioEntre(int menor, int mayor);
}
