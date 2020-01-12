package com.empresa.sboot.pruebabpt.controllers;

import com.empresa.sboot.pruebabpt.models.entity.Producto;
import com.empresa.sboot.pruebabpt.models.service.ProductoDto;
import com.empresa.sboot.pruebabpt.models.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    public ProductoDto show(@PathVariable(value = "id") String id){
        ProductoDto productoDto = modelMapper.map(productoService.findById(id), ProductoDto.class);
        return productoDto;
    }

    @GetMapping("/producto/getproductos/{id}")
    public List<ProductoDto> getProductos(@PathVariable(value = "id") @Valid String id){
        Type listType = new TypeToken<List<ProductoDto>>(){}.getType();
        List<ProductoDto> productoDtoList = modelMapper.map(productoService.findByNitProveedor(id),listType);
        return productoDtoList;
    }

    @GetMapping("/producto/getproductosmayorque/{valor}")
    public List<ModelMap> getProductosMayorQue(@PathVariable(value = "valor") @Valid int valor){
        List<Object[]> objects = productoService.findByPrecioMayorQue(valor);

        List<ModelMap> modelMapList = new ArrayList<>();

        for (Object[] object: objects) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("nomProducto",object[0]);
            modelMap.addAttribute("precioProducto",object[1]);
            modelMapList.add(modelMap);
        }

        return modelMapList;
    }

    @GetMapping("/producto/getnameproductospornit/{id}")
    public List<ModelMap> getNameProductosPorNit(@PathVariable(value = "id") @Valid String id){

        List<Object[]> objects = productoService.findNameByNitProveedor(id);
        List<ModelMap> modelMapList = new ArrayList<>();

        for (Object[] object: objects) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("nombre",object[0]);
            modelMapList.add(modelMap);
        }

        return modelMapList;
    }

    @GetMapping("/producto/getproductospornit/{id}")
    public List<ProductoDto> getProductosPorNit(@PathVariable(value = "id") @Valid String id){
        Type listType = new TypeToken<List<ProductoDto>>(){}.getType();
        List<ProductoDto> productoDtoList = modelMapper.map(productoService.findByNitProveedor(id),listType);
        return productoDtoList;
    }

    @GetMapping("/producto/getproductosentre/{menor}/{mayor}")
    public List<ModelMap> getProductosEntre(@PathVariable(value = "menor") @Valid int menor, @PathVariable(value = "mayor") @Valid int mayor){
        List<Object[]> objects = productoService.findByPrecioEntre(menor, mayor);

        List<ModelMap> modelMapList = new ArrayList<>();

        for (Object[] object: objects) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("nomProducto",object[0]);
            modelMap.addAttribute("precioProducto",object[1]);
            modelMapList.add(modelMap);
        }

        return modelMapList;
    }

}
