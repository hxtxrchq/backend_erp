package com.erp.erp.compras.mapper;

import com.erp.erp.compras.dto.MovimientoStockDTO;
import com.erp.erp.compras.entidad.MovimientoStock;
import com.erp.erp.compras.entidad.Producto;
import com.erp.erp.compras.entidad.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class MovimientoStockMapper {

    public MovimientoStockDTO toDTO(MovimientoStock entity) {
        if (entity == null) return null;
        return new MovimientoStockDTO(
                entity.getId(),
                entity.getProducto() != null ? entity.getProducto().getId() : null,
                entity.getProveedor() != null ? entity.getProveedor().getId() : null,
                entity.getTipoMovimiento(),
                entity.getCantidad(),
                entity.getFecha()
        );
    }

    public MovimientoStock toEntity(MovimientoStockDTO dto) {
        if (dto == null) return null;
        MovimientoStock entity = new MovimientoStock();
        entity.setId(dto.id());
        
        if (dto.productoId() != null) {
            Producto p = new Producto();
            p.setId(dto.productoId());
            entity.setProducto(p);
        }
        
        if (dto.proveedorId() != null) {
            Proveedor pv = new Proveedor();
            pv.setId(dto.proveedorId());
            entity.setProveedor(pv);
        }
        
        entity.setTipoMovimiento(dto.tipoMovimiento());
        entity.setCantidad(dto.cantidad());
        entity.setFecha(dto.fecha());
        return entity;
    }
}
