package com.empresa.sboot.pruebabpt.controllers;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import com.empresa.sboot.pruebabpt.models.service.ProductoDto;
import com.empresa.sboot.pruebabpt.models.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ProductoController {

    private ProductoService productoService;
    private ModelMapper modelMapper;

    public ProductoController(ProductoService productoService, ModelMapper modelMapper) {
        this.productoService = productoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/producto")
    public List<ProductoDto> findAll() {
        Type listType = new TypeToken<List<ProductoDto>>(){}.getType();
        List<ProductoDto> productoDtoList = modelMapper.map(productoService.findAll(),listType);
        return productoDtoList;
    }

    @GetMapping("/producto/{id}")
    public ProductoDto show(@PathVariable(value = "id") Long id){
        ProductoDto productoDto = modelMapper.map(productoService.findById(id), ProductoDto.class);
        return productoDto;
    }
}
