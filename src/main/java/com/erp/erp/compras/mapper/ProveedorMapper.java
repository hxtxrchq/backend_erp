package com.erp.erp.compras.mapper;

import com.erp.erp.compras.dto.ProveedorDTO;
import com.erp.erp.compras.entidad.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public ProveedorDTO toDTO(Proveedor entity) {
        if (entity == null) return null;
        return new ProveedorDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getRuc(),
                entity.getTelefono()
        );
    }

    public Proveedor toEntity(ProveedorDTO dto) {
        if (dto == null) return null;
        Proveedor entity = new Proveedor();
        entity.setId(dto.id());
        entity.setNombre(dto.nombre());
        entity.setRuc(dto.ruc());
        entity.setTelefono(dto.telefono());
        return entity;
    }
}
