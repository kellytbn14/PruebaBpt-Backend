package com.empresa.sboot.pruebabpt.controllers;

import com.empresa.sboot.pruebabpt.facade.ProveedorFacade;
import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import com.empresa.sboot.pruebabpt.models.service.ProveedorDto;
import com.empresa.sboot.pruebabpt.models.service.ProveedorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ProveedorController {

    private ProveedorService proveedorService;
    private ModelMapper modelMapper;
    private final ProveedorFacade proveedorFacade;

    public ProveedorController(ProveedorService proveedorService, ModelMapper modelMapper, ProveedorFacade proveedorFacade) {
        this.modelMapper = modelMapper;
        this.proveedorService = proveedorService;
        this.proveedorFacade = proveedorFacade;
    }

    @GetMapping("/proveedor")
    public List<ProveedorDto> findAll() {
       // Type listType = new TypeToken<List<ProveedorDto>>(){}.getType();
      //  List<ProveedorDto> proveedorDtoList = modelMapper.map(proveedorService.findAll(),listType);
        List<ProveedorDto> proveedorDtoList = this.proveedorFacade.findAll();

        return proveedorDtoList;
    }

    @GetMapping("/proveedor/{id}")
    public ProveedorDto show(@PathVariable(value = "id") String id) {
        ProveedorDto proveedorDto = modelMapper.map(proveedorService.findById(id), ProveedorDto.class);
        return proveedorDto;
    }

    @GetMapping("/proveedor/getnameproveedorporcod/{id}")
    public List<ModelMap> getNameProveedorPorCodigoProducto(@PathVariable(value = "id") @Valid String id){

        List<Object[]> objects = proveedorService.findByCodProducto(id);
        List<ModelMap> modelMapList = new ArrayList<>();

        for (Object[] object: objects) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("nomProveedor",object[0]);
            modelMapList.add(modelMap);
        }

        return modelMapList;
    }
}


