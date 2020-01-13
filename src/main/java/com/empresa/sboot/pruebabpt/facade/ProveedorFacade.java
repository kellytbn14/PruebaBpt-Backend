package com.empresa.sboot.pruebabpt.facade;

import com.empresa.sboot.pruebabpt.mapper.ProveedorMapper;
import com.empresa.sboot.pruebabpt.models.service.ProveedorDto;
import com.empresa.sboot.pruebabpt.models.service.ProveedorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProveedorFacade {

    private final ProveedorService proveedorService;
    private final ProveedorMapper proveedorMapper;

    public ProveedorFacade(ProveedorService proveedorService, ProveedorMapper proveedorMapper) {
        this.proveedorService = proveedorService;
        this.proveedorMapper = proveedorMapper;
    }

    public List<ProveedorDto> findAll() {
        return proveedorMapper.toDto(this.proveedorService.findAll());
    }
}
