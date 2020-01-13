package com.empresa.sboot.pruebabpt.mapper;

import com.empresa.sboot.pruebabpt.mapper.base.EntityMapper;
import com.empresa.sboot.pruebabpt.models.entity.Producto;
import com.empresa.sboot.pruebabpt.models.service.ProductoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper extends EntityMapper<ProductoDto, Producto> {
}
