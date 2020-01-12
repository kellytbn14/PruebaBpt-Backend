package com.empresa.sboot.pruebabpt.models.service;

import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import com.empresa.sboot.pruebabpt.models.persistence.ProveedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;
    private ModelMapper modelMapper;

    public ProveedorService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProveedorService() {
    }

    public Proveedor findById(String nitProveedor){
        return proveedorRepository.findById(nitProveedor).orElse(null);
    }

    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    public List<Object[]> findByCodProducto(String codigo){
        return proveedorRepository.findByCodProducto(codigo);
    }


}
