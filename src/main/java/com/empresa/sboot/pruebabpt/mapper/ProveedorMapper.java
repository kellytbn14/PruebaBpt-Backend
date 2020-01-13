package com.empresa.sboot.pruebabpt.mapper;

import com.empresa.sboot.pruebabpt.mapper.base.EntityMapper;
import com.empresa.sboot.pruebabpt.models.entity.Proveedor;
import com.empresa.sboot.pruebabpt.models.service.ProveedorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProveedorMapper extends EntityMapper<ProveedorDto, Proveedor> {
}
