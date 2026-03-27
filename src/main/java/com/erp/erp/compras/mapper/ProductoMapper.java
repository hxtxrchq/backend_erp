package com.erp.erp.compras.mapper;

import com.erp.erp.compras.dto.ProductoDTO;
import com.erp.erp.compras.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto entity) {
        if (entity == null) return null;
        return new ProductoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getStock(),
                entity.getPrecio()
        );
    }

    public Producto toEntity(ProductoDTO dto) {
        if (dto == null) return null;
        Producto entity = new Producto();
        entity.setId(dto.id());
        entity.setNombre(dto.nombre());
        entity.setStock(dto.stock() != null ? dto.stock() : 0);
        entity.setPrecio(dto.precio());
        return entity;
    }
}
