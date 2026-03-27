package com.erp.erp.compras.dto;

import java.time.LocalDateTime;

public record MovimientoStockDTO(
        Integer id,
        Integer productoId,
        Integer proveedorId,
        String tipoMovimiento,
        Integer cantidad,
        LocalDateTime fecha
) {
}
