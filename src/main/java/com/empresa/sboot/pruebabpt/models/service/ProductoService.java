package com.empresa.sboot.pruebabpt.models.service;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import com.empresa.sboot.pruebabpt.models.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto findById(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> findByNitProveedor(String nit){
        return productoRepository.findByNitProveedor(nit);
    }

    public List<Object[]> findByPrecioMayorQue(){
        return productoRepository.findByPrecioMayorQue();
    }

    public List<Object[]> findNameByNitProveedor(String nit){
        return productoRepository.findNameByNitProveedor(nit);
    }

    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    public List<Object[]> findByPrecioEntre(){
        return productoRepository.findByPrecioEntre();
    }
}
