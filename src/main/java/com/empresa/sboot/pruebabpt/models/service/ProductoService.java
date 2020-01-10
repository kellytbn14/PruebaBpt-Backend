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

    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }
}
