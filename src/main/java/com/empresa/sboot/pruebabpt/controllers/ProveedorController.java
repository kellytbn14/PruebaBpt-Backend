package com.empresa.sboot.pruebabpt.controllers;

import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import com.empresa.sboot.pruebabpt.models.service.ProveedorDto;
import com.empresa.sboot.pruebabpt.models.service.ProveedorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ProveedorController {

    private ProveedorService proveedorService;
    private ModelMapper modelMapper;

    public ProveedorController(ProveedorService proveedorService, ModelMapper modelMapper) {
        this.proveedorService = proveedorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/proveedor")
    public List<ProveedorDto> findAll() {
        Type listType = new TypeToken<List<ProveedorDto>>(){}.getType();
        List<ProveedorDto> proveedorDtoList = modelMapper.map(proveedorService.findAll(),listType);
        return proveedorDtoList;
    }

    @GetMapping("/proveedor/{id}")
    public ProveedorDto show(@PathVariable(value = "id") String id) {
        ProveedorDto proveedorDto = modelMapper.map(proveedorService.findById(id), ProveedorDto.class);
        return proveedorDto;
    }
}


